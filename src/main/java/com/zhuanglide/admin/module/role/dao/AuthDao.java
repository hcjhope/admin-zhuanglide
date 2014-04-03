package com.zhuanglide.admin.module.role.dao;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.Auth;

public interface AuthDao {

	/**
	 * 查询所有auth
	 * 
	 * @return
	 */
	public List<Auth> selectList() throws Exception;


	/**
	 * 增加
	 * 
	 * @param auth
	 * @return
	 */
	public long insert(Auth auth) throws Exception;

	/**
	 * 更新
	 * 
	 * @param auth
	 * @return
	 */
	public int updateById(Auth auth) throws Exception;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(long id) throws Exception;
}
