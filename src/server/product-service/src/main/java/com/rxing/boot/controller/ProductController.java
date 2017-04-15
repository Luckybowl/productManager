package com.rxing.boot.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rxing.boot.dao.IProductDao;
import com.rxing.boot.entity.Product;

/**
 * 商品操作服务
 * @author wxh
 * 2017年4月15日
 */
@RestController
public class ProductController {
	private static final Logger LOGGER=LogManager.getLogger(ProductController.class);
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private DiscoveryClient client;
	
	/**
	 * 添加商品
	 * @param product--需要添加的商品
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public int addProduct(@RequestParam Product product) {
		Product result=productDao.save(product);
		if (result!=null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 根据商品名字获取商品
	 * @param productName
	 * @return
	 */
	@RequestMapping(value="/getProductByName",method=RequestMethod.GET)
	public Product getProductByName(@RequestParam String productName){
		ServiceInstance instance=client.getLocalServiceInstance();
		Product product=productDao.getProductByName(productName);
		LOGGER.info("/getProductByName,host:"+instance.getHost()+",service_id:"+instance.getServiceId()+",result:"+productName.toString());
		return product;
	}
	
	
	
	/**
	 * 获取所有商品
	 * @return
	 */
	@RequestMapping(value="findAll",method=RequestMethod.GET)
	public Iterable<Product> findAllProduct(){
		return productDao.findAll();
	}
	
	/**
	 * 根据ID获取商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findById",method=RequestMethod.GET)
	public Product findOne(@RequestParam Long id){
		return productDao.findOne(id);
	}
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param size
	 * @param properties
	 * @return
	 */
	@RequestMapping(value="page",method=RequestMethod.GET)
	public Page<Product> findOne(@RequestParam int page,@RequestParam int size,@RequestParam List<String> properties){
		Page<Product>  product=productDao.findAll(new MySpec(),new PageRequest(page, size,new Sort(Direction.DESC,properties)));		
		return product;
	}
	
	/**
	 * 删除指定商品
	 * @param product
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public void  delete(@RequestParam Product product){
		productDao.delete(product);
	}
	
	/**
	 * 自定义查询方式
	 */
	private class MySpec implements Specification<Product>{
		@Override
		public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {			
			// 多条件分页查询
			Path<String> exp1= root.get("productName");
			Path<String> exp2=root.get("productRest");			 
			query.where(cBuilder.like(exp1, "%ban%"),cBuilder.equal(exp2, "56"));		
			return null;
		}
	}
	
}
