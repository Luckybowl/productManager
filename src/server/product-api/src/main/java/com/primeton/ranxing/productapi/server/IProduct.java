package com.primeton.ranxing.productapi.server;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.primeton.ranxing.productapi.entity.Product;

/**
 * Feign 客户端 使用 wxh实现的db-server服务
 * @author linjx
 * @time 2017-04-15
 */

@FeignClient("db-service")
public interface IProduct {
	
	/**
	 * 添加商品
	 * @param product--需要添加的商品
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public int addProduct(@RequestParam Product product);
	
	/**
	 * 根据商品名字获取商品
	 * @param productName
	 * @return
	 */
	@RequestMapping(value="/getProductByName",method=RequestMethod.GET)
	public Product getProductByName(@RequestParam String productName);
	
	
	
	/**
	 * 获取所有商品
	 * @return
	 */
	@RequestMapping(value="findAll",method=RequestMethod.GET)
	public Iterable<Product> findAllProduct();
	
	/**
	 * 根据ID获取商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findById",method=RequestMethod.GET)
	public Product findOne(@RequestParam Long id);
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param size
	 * @param properties
	 * @return
	 */
	@RequestMapping(value="page",method=RequestMethod.GET)
	public Page<Product> findOne(@RequestParam int page,@RequestParam int size,@RequestParam List<String> properties);
	
	/**
	 * 删除指定商品
	 * @param product
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public void  delete(@RequestParam Product product);
	

}
