package com.zhuanglide.admin.module.role.entity;

import java.io.Serializable;

public class RoleGroup implements Serializable{
	
	private static final long serialVersionUID = -4936667376506522378L;
	private long id; // id
	private String groupName; // 角色组名称
	private String groupDesc; // 角色组秒
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
}
