package com.zhuanglide.demo.module.test.service;

import java.util.List;

public interface LuceneService {
	public void addIndex();
	public List<String> query(String keyword);
}
