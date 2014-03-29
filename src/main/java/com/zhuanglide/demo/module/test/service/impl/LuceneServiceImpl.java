package com.zhuanglide.demo.module.test.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKQueryParser;
import org.wltea.analyzer.lucene.IKSimilarity;

import com.zhuanglide.demo.module.test.dao.TestDao;
import com.zhuanglide.demo.module.test.entry.City;
import com.zhuanglide.demo.module.test.service.LuceneService;

@Service("luceneService")
public class LuceneServiceImpl implements LuceneService{
	@Autowired
	private TestDao testDao;
	
	
	private static Directory directory;
	static{
		try {
			directory = FSDirectory.open(new File("D://workspace//luceneIndex"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Analyzer analyzer = new IKAnalyzer();
	public void addIndex(){
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		try {
			IndexWriter idw = new IndexWriter(directory,iwc);
			idw.deleteAll();
			List<City> cityList = null;
			try {
				cityList = testDao.selectCityList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(City city : cityList){
				Document doc = new Document();
				doc.add(new Field("id",String.valueOf(city.getId()),Field.Store.NO,Field.Index.NOT_ANALYZED));
				doc.add(new Field("citycode", String.valueOf(city.getCityCode()), Field.Store.NO,Field.Index.NOT_ANALYZED));
				doc.add(new Field("cityname",city.getCityName(),Field.Store.YES,Field.Index.ANALYZED));
				idw.addDocument(doc);
			}
			idw.close();
			
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> query(String keyword){
		List<String> list = new ArrayList<String>();
		try {
			IndexReader ir = IndexReader.open(directory);
			IndexSearcher ids = new IndexSearcher(ir);
			ids.setSimilarity(new IKSimilarity()); 
			Query query = IKQueryParser.parse("cityname", keyword);
			
			TopDocs topDocs = ids.search(query, 10);
			System.out.println("命中：" + topDocs.totalHits);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for(ScoreDoc doc : scoreDocs){
				ids.doc(doc.doc);
				list.add(ids.doc(doc.doc).toString());
			}
			
			ids.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public static void main(String[] args) {
		String keyword="石";
		List<String> list = new ArrayList<String>();
		try {
			Directory	directory = FSDirectory.open(new File("D://workspace//luceneIndex"));
			IndexReader ir = IndexReader.open(directory);
			IndexSearcher ids = new IndexSearcher(ir);
			ids.setSimilarity(new IKSimilarity()); 

			Query query = IKQueryParser.parse("cityname", keyword);
			
			TopDocs topDocs = ids.search(query, 10);
			System.out.println("命中：" + topDocs.totalHits);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for(ScoreDoc doc : scoreDocs){
				ids.doc(doc.doc);
				list.add(ids.doc(doc.doc).toString());
			}
			System.out.println(list);
			ids.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}
}
