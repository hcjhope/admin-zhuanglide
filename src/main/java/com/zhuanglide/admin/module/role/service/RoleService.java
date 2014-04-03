package com.zhuanglide.admin.module.role.service;

import java.util.List;

import com.zhuanglide.admin.module.role.entity.Role;
import com.zhuanglide.admin.module.role.entity.RoleGroup;
import com.zhuanglide.admin.module.role.entity.UserRole;

public interface RoleService {
	
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserRole> queryUserRoleList(long userId) throws Exception;
	
	/**
	 * 添加用户权限
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public boolean addUserRole(UserRole userRole) throws Exception;
	
	/**
	 * 添加组
	 * @param roleGroup
	 * @return
	 * @throws Exception 
	 */
	public boolean addRoleGroup(RoleGroup roleGroup) throws Exception;
	
	/**
	 * 添加权限
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role) throws Exception;
	
}
