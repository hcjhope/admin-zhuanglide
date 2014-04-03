package com.zhuanglide.admin.module.role.entity;

import java.io.Serializable;
import java.util.Date;

public class UserRole implements Serializable {
	private static final long serialVersionUID = -6065559525211614692L;

	private long id; // 主键
	private long userId; // 用户ID
	private long groupId; // 角色组ID
	private long roleId; // 角色ID
	private long operatorId; // 操作人
	private Date createTime; // 创建时间

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
