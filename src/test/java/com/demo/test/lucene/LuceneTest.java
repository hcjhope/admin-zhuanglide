package com.demo.test.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneTest {
	private  String indexPath = "D://luceneIndex";
	private  Directory directory ;
	
	public void addIndex(){
		IndexWriter indexWriter = null;
		try {
			directory = FSDirectory.open(new File(indexPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		try {
			indexWriter	= new IndexWriter(directory, iwc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Document doc = new Document();
		doc.add(new Field("content","haha",Store.YES,Field.Index.ANALYZED_NO_NORMS));
		doc.add(new Field("name","haha",Store.YES,Field.Index.ANALYZED_NO_NORMS));	
		try {
			indexWriter.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			indexWriter.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void search(){
		try {
			directory = FSDirectory.open(new File(indexPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IndexReader indexReader = null;
		try {
			indexReader = IndexReader.open(directory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IndexSearcher indexSearch = new IndexSearcher(indexReader);
		
		QueryParser parse = new QueryParser(Version.LUCENE_36,"content",new StandardAnalyzer(Version.LUCENE_36));
		try {
			Query query = parse.parse("queryText");
			TopDocs tds = indexSearch.search(query, 100);
            ScoreDoc[] sds = tds.scoreDocs;
            
            for(ScoreDoc sd:sds)
            {
                //7.根据Search和ScoreDoc对象获取具体的Document对象
                Document  d = indexSearch.doc(sd.doc);
                
                //8.根据document对象获取需要的值                
                System.out.println(d.get("filename")+"|"+d.get("path"));
            }
            } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
