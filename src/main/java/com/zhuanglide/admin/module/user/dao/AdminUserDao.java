package com.zhuanglide.admin.module.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.user.entiry.AdminUser;

@Repository
public interface AdminUserDao {
	
	AdminUser selectById(@Param("id")long id) throws Exception;
	
	AdminUser selectByUserName(@Param("userName")String userName) throws Exception;
	
	int insertAdminUser(@Param("adminUser")AdminUser adminUser) throws Exception;
	
	int updateAdminUser(@Param("adminUser")AdminUser adminUser) throws Exception;
	
	List<AdminUser> selectByList(@Param("params")Map<String,Object> params,@Param("limit") int limit,@Param("size") int size) throws Exception;
}
