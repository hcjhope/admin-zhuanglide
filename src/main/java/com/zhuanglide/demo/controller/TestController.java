package com.zhuanglide.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhuanglide.demo.module.test.entry.Test;
import com.zhuanglide.demo.module.test.entry.User;
import com.zhuanglide.demo.module.test.service.LuceneService;
import com.zhuanglide.demo.module.test.service.TestService;

@Controller
@RequestMapping("/test.do")
public class TestController {
	private static final Log logger = LogFactory.getLog(TestController.class);
	@Autowired
	private TestService testService;

	@Autowired
	private LuceneService luceneService;
	
	@RequestMapping(params = "method=city")
	public void city(HttpServletRequest request) {
		String city = request.getParameter("city");
		luceneService.addIndex();
		List<String> query = luceneService.query(city);
		System.out.println(query);
	}
	@RequestMapping(params = "method=list")
	public void test() {
		List<Test> queryForList = testService.queryForList();
		logger.info(queryForList);

		List<User> userList = null;
		try {
			userList = testService.queryUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(userList);
//		User user = new User();
//		user.setUserName("wwj");
//		user.setPassword("123456");
//		try {
//			testService.addUser(user);
//			user.setUserName("wangweijie");
//			testService.addUser(user);
//
//			user.setUserName("-----");
//			testService.updateUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// queryForList = testService.queryForList();
		//
		// for(Test t : queryForList){
		// logger.info("test.id="+t.getId() + ",name="+t.getName());
		// }
	}
}
