package com.zhuanglide.admin.module.role.entity;

import java.io.Serializable;

public class Auth implements Serializable {
	private static final long serialVersionUID = 1336182523585769581L;

	private long id;// 主键',
	private String authName;// 权限名称',
	private String authUrl;// 可执行url',
	private String authDesc;// 权限描述',
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	public String getAuthDesc() {
		return authDesc;
	}
	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}
}
