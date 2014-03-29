package com.demo.test.lucene;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;


public class IKAnalyzerTest {
	@Test
	public void test(){
		String str = "我爱北京天安门，天安门上太阳升";
		IKAnalyzer analyzer = new IKAnalyzer();
		StringReader reader = new StringReader(str);
		IKSegmentation ikSegmentation = new IKSegmentation(reader,true);
		try {
			Lexeme next = ikSegmentation.next();
			while(next!=null){
				System.out.print(next.getLexemeText()+"|");
				next = ikSegmentation.next();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
