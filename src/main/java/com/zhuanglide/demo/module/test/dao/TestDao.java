package com.zhuanglide.demo.module.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhuanglide.demo.module.test.entry.City;
import com.zhuanglide.demo.module.test.entry.Test;

@Repository
public interface TestDao {
    public List<Test> selectTestList() throws Exception;
    public List<City> selectCityList() throws Exception;
    
    public int insertTest(Test test) throws Exception;
}
