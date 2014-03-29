package com.zhuanglide.demo.module.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhuanglide.demo.module.test.entry.City;

@Repository
public interface CityDao {
	public List<City> selectCityList()  throws Exception;
}
