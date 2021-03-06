package com.primeton.ranxing.productapi.server;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.primeton.ranxing.productapi.entity.Category;
import com.primeton.ranxing.productapi.entity.Product;

/**
 * Feign 客户端 使用 wxh实现的db-server服务
 * 
 * @author linjx
 * @time 2017-04-15
 */

@FeignClient("db-service")
public interface IProduct {

	/**
	 * 添加商品
	 * 
	 * @param product--需要添加的商品
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	int addProduct(@RequestBody Product product);

	/**
	 * 根据商品名字获取商品
	 * 
	 * @param productName
	 * @return
	 */
	@RequestMapping(value = "/getProductByName", method = RequestMethod.GET)
	Product getProductByName(@RequestParam("productName") String productName);

	/**
	 * 获取所有商品
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	Iterable<Product> findAllProduct();

	/**
	 * 根据ID获取商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	Product findOne(@RequestParam("id") Long id);
	
	
	/**
	 * 分类查询
	 * @param categoryName --类型名
	 * @return
	 */
	@RequestMapping(value="/findAllByCategory",method=RequestMethod.GET)
	List<Product> findAllByCategory(@RequestParam("categoryName") String categoryName);

	/**
	 * 按条件分页查询
	 * 
	 * @param page
	 *            --页数
	 * @param size
	 *            --页面大小
	 * @param properties
	 *            --排序属性
	 * @param prod
	 *            --商品条件参数
	 * @param cate
	 *            --类型条件参数
	 * @return
	 */
	@RequestMapping(value = "/findAllByConditonWithPage", method = RequestMethod.GET)
	Iterable<Product> findAllByConditonWithPage(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("properties") List<String> properties);

	/**
	 * 删除指定商品
	 * @param product
	 */
	@RequestMapping(value="/deleteProduct",method=RequestMethod.GET)
	public void  deleteProduct(@RequestParam("id") Long id);

	/**
	 * 批量删除指定商品
	 * 
	 * @param
	 * @param products
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.GET)
	void deleteBatch();
	
	
	@RequestMapping(value="/findAllCate",method=RequestMethod.GET)
	 Iterable<Category> findAllCategory();
	

}
