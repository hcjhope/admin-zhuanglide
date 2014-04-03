package com.zhuanglide.admin.module.role.dao;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.RoleGroup;

public interface RoleGroupDao {
	
	public List<RoleGroup> selectList() throws Exception;
	
	public RoleGroup selectById(long id) throws Exception;
	
	public long insert(RoleGroup roleGroup) throws Exception;
	
	public int update(RoleGroup roleGroup) throws Exception;
	
	public int delete(long id) throws Exception;
}
