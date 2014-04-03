package com.zhuanglide.admin.module.role.entity;

import java.io.Serializable;

public class RoleAuth implements Serializable{
	private static final long serialVersionUID = -6567025679576966977L;
	private long id; // 主键
	private long roleId; // 角色ID
	private long authId; // 权限ID
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getAuthId() {
		return authId;
	}
	public void setAuthId(long authId) {
		this.authId = authId;
	}
}
