package com.zhuanglide.admin.module.role.dao;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.RoleAuth;

public interface RoleAuthDao {
	/**
	 * 查询全部
	 * @return
	 */
	public List<RoleAuth> selectList() throws Exception;
	
	/**
	 * 根据角色ID查询
	 * @return
	 */
	public List<RoleAuth> selectListByRoleId(long roleId) throws Exception;
	
	/**
	 * 插入
	 * @return
	 */
	public long insert(RoleAuth roleAuth) throws Exception;
	
	/**
	 * 更新
	 * @param roleAuth
	 * @return
	 */
	public int update(RoleAuth roleAuth) throws Exception;
	
	public int deleteById(long id) throws Exception;
}
