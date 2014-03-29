package com.zhuanglide.admin.module.user.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuanglide.admin.module.user.dao.AdminUserDao;
import com.zhuanglide.admin.module.user.entiry.AdminUser;
import com.zhuanglide.admin.module.user.service.AdminUserService;
import com.zhuanglide.util.SecurityUtils;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
	private Logger logger = Logger.getLogger(AdminUserServiceImpl.class);
	@Autowired
	private AdminUserDao adminUserDao;

	
	@Override
	public AdminUser queryByUserName(String userName) {
		AdminUser au = null;
		try{
			au = adminUserDao.selectByUserName(userName);
		}catch(Exception e){
			logger.error("查询admin_user异常", e);
		}
		return au;
	}
	
	
	
	@Override
	public AdminUser login(String userName, String password) {
		AdminUser au = null;
		try{
			au = adminUserDao.selectByUserName(userName);
			if(au!=null){
				if(!au.getPassword().equals(SecurityUtils.MD5Encode(password))){
					if(logger.isDebugEnabled()){
						logger.debug("password error ! username="+userName+",password="+password);
					}
					au = null;
				}
			}
		}catch(Exception e){
			logger.error("查询admin_user异常", e);
		}
		return au;
	
	}


	@Override
	public AdminUser queryById(long id) {
		AdminUser au = null;
		try{
			au = adminUserDao.selectById(id);
		}catch(Exception e){
			logger.error("查询admin_user异常", e);
		}
		return au;
	}

	@Override
	public boolean addAdminUser(AdminUser adminUser) {
		adminUser.setStatus(1);
		adminUser.setPassword(SecurityUtils.MD5Encode(adminUser.getPassword()));
		
		int rs = 0;
		try{
			rs = adminUserDao.insertAdminUser(adminUser);
		}catch(Exception e){
			logger.error("更新admin_user异常", e);
		}
		return rs>0;
	}
	
	
}
