package com.zhuanglide.admin.module.user.entiry;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable {
	private static final long serialVersionUID = -962848230807581305L;
	
	private long id; 			// 主键
	private String userName; 	// 用户名
	private String password;	// 密码,
	private String email;		// 邮箱,
	private String mobile;		// 手机号,
	private int status;		// 状态（0：新建，1：正常，2：无效,
	private long operatorId;	// 创建人
	private Date createTime;	// 创建时间,
	private Date updateTime;	// 更新时间,
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
}
