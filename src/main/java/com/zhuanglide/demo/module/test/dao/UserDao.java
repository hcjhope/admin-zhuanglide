package com.zhuanglide.demo.module.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhuanglide.demo.module.test.entry.User;
@Repository
public interface UserDao {

	public List<User> selectList(@Param("params")Map<String,Object> params,@Param("limit")int limit,@Param("size") int size) throws Exception;
	public int insertUser(User user) throws Exception;
	public int updateUser(User user) throws Exception;
}
