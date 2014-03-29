package com.demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhuanglide.demo.module.test.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class DemoTest extends AbstractJUnit4SpringContextTests{
	private Logger logger = Logger.getLogger(DemoTest.class);
	@Autowired
	private TestService testService;
	@Test
	public void testSQL(){
		List<com.zhuanglide.demo.module.test.entry.Test> queryForList = testService.queryForList();
		logger.error("=------------------"+queryForList);;
		logger.error(")00");
	}
}
