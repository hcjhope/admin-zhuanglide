package com.zhuanglide.admin.module.role.dao;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.UserRole;

public interface UserRoleDao {
	public List<UserRole> selectList() throws Exception;
	
	public List<UserRole> selectListByUserId(long userId) throws Exception;
	
	public UserRole selectById(long id) throws Exception;
	
	public long insert(UserRole userRole) throws Exception;
	
	public int update(UserRole userRole) throws Exception;
	
	public int delete(long id) throws Exception;
}
