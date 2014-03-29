package com.zhuanglide.demo.module.test.entry;

import java.io.Serializable;

public class City implements Serializable{
	private static final long serialVersionUID = 8543459639047511923L;
	
	private long id;
	private long cityCode;
	private String cityName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCityCode() {
		return cityCode;
	}
	public void setCityCode(long cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
