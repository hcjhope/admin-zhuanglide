package com.zhuanglide.demo.module.test.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuanglide.demo.module.test.dao.TestDao;
import com.zhuanglide.demo.module.test.dao.UserDao;
import com.zhuanglide.demo.module.test.entry.Test;
import com.zhuanglide.demo.module.test.entry.User;
import com.zhuanglide.demo.module.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{
    @Autowired
    private TestDao testDao;
    @Autowired
    private UserDao userDao;

    public List<Test> queryForList() {
        try {
			return testDao.selectTestList();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    @Override
    public long addTest(Test test) throws Exception {
			int rs = testDao.insertTest(test);
			
			Object obj = this.testDao.selectTestList();
			if(rs < 0){
				throw new Exception();
			}
	        throw new RuntimeException();
    }

	@Override
	public List<User> queryUserList() throws Exception {
		return userDao.selectList(new HashMap<String, Object>(), 0, 100);
	}

	@Override
	public long addUser(User user) throws Exception {
		int rs = userDao.insertUser(user);
		if(rs>0){
			return user.getId();
		}
		return 0L;
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}
    
    
    
}
