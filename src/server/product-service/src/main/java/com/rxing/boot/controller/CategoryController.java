package com.rxing.boot.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rxing.boot.dao.ICategoryDao;
import com.rxing.boot.entity.Category;

@RestController
public class CategoryController {
	private static final Logger LOGGER=LogManager.getLogger(ProductController.class);
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/findAllCate",method=RequestMethod.GET)
	public Iterable<Category> findAllCategory(){
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/findAll,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return categoryDao.findAll();
	}
}
