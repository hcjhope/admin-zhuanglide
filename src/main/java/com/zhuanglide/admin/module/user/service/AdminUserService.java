package com.zhuanglide.admin.module.user.service;

import com.zhuanglide.admin.module.user.entiry.AdminUser;

public interface AdminUserService {

	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public AdminUser queryByUserName(String userName);
	
	/**
	 *  根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public AdminUser queryById(long id);
	
	/**
	 * 添加新用户
	 * @param adminUser
	 * @return
	 */
	public boolean addAdminUser(AdminUser adminUser);
	
	/**
	 * 用户登陆判断，null代表用户名或密码错误，登陆成功获得AdminUser对象
	 * @param userName
	 * @param password
	 * @return
	 */
	public AdminUser login(String userName,String password);
}
