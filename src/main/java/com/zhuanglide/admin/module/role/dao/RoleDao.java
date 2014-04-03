package com.zhuanglide.admin.module.role.dao;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.Role;

public interface RoleDao {

	/**
	 * 查询所有auth
	 * 
	 * @return
	 */
	public List<Role> selectList() throws Exception;

	/**
	 * 根据group_id查询
	 * 
	 * @param groupId
	 * @return
	 */
	public List<Role> selectListByGroupId(long groupId) throws Exception;

	/**
	 * 增加
	 * 
	 * @param role
	 * @return
	 */
	public long insert(Role role) throws Exception;

	/**
	 * 更新
	 * 
	 * @param role
	 * @return
	 */
	public int updateById(Role role) throws Exception;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(long id) throws Exception;
}
