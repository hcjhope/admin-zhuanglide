package com.zhuanglide.admin.module.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhuanglide.admin.module.role.dao.AuthDao;
import com.zhuanglide.admin.module.role.dao.RoleAuthDao;
import com.zhuanglide.admin.module.role.dao.RoleDao;
import com.zhuanglide.admin.module.role.dao.RoleGroupDao;
import com.zhuanglide.admin.module.role.dao.UserRoleDao;
import com.zhuanglide.admin.module.role.entity.Role;
import com.zhuanglide.admin.module.role.entity.RoleGroup;
import com.zhuanglide.admin.module.role.entity.UserRole;
import com.zhuanglide.admin.module.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource(name="authDao")
	private AuthDao authDao;
	@Resource(name="roleAUthDao")
	private RoleAuthDao roleAUthDao;
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Resource(name="roleGroupDao")
	private RoleGroupDao roleGroupDao;
	@Resource(name="userRoleDao")
	private UserRoleDao userRoleDao;
	
	
	
	@Override
	public List<UserRole> queryUserRoleList(long userId) throws Exception {
		return userRoleDao.selectListByUserId(userId);
	}

	@Override
	public boolean addUserRole(UserRole userRole) throws Exception {
		long id = userRoleDao.insert(userRole);
		return id>0L;
	}

	@Override
	public boolean addRoleGroup(RoleGroup roleGroup) throws Exception{
		long id = roleGroupDao.insert(roleGroup);
		return id>0L;
	}

	@Override
	public boolean addRole(Role role) throws Exception {
		long id = roleDao.insert(role);
		return id>0L;
	}
}
