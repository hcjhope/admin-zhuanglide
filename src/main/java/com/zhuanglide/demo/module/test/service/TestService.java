package com.zhuanglide.demo.module.test.service;

import java.util.List;

import com.zhuanglide.demo.module.test.entry.Test;
import com.zhuanglide.demo.module.test.entry.User;


public interface TestService {
    public List<Test> queryForList();
    
    public long addTest(Test test) throws Exception;
    
    public List<User> queryUserList() throws Exception;
    
    public long addUser(User user) throws Exception;
    
    public int updateUser(User user) throws Exception;
    
}
