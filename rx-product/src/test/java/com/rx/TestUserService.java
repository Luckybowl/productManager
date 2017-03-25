package com.rx;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})  

public class TestUserService {
	
	private static Logger logger = Logger.getLogger(TestUserService.class); 
	
	@Test
	public void testFindUserById() {
		logger.info("aaa");
	}
	
	@Test
	public void testFindUserByUserName() {
	}
}
