package com.rxing.boot.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rxing.boot.dao.IProductDao;
import com.rxing.boot.entity.Category;
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
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public int addProduct(@RequestBody Product product) {
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
		Product product=productDao.getProductByName(productName);
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/getProductByName,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return product;
	}
	
	/**
	 * 获取所有商品
	 * @return
	 */
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public Iterable<Product> findAllProduct(){
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/findAll,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return productDao.findAll();
	}
	
	/**
	 * 根据ID获取商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public Product findOne(@RequestParam Long id){
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/findById,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return productDao.findOne(id);
	}
	
	/**
	 * 分类查询
	 * @param categoryName --类型名
	 * @return
	 */
	@RequestMapping(value="/findAllByCategory",method=RequestMethod.GET)
	public List<Product> findAllByCategory(@RequestParam String categoryName){
		return productDao.findAll(new MySpecCate(categoryName));
	}
	
	/**
	 * 自定义分类查询
	 */
	private class MySpecCate implements Specification<Product>{
		private String categoryName;
		public MySpecCate(String categoryName) {
			this.categoryName=categoryName;
		}
		
		@Override
		public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {
			Path<String> cateName=root.join("category",JoinType.INNER).get("categoryName");
			String result="%"+categoryName.substring(1, categoryName.length()-1)+"%";
			System.out.println(result);
			return cBuilder.like(cateName, result);
		
	}
	
	/**
	 * 按条件分页查询
	 * @param page --页数
	 * @param size --页面大小
	 * @param properties --排序属性
	 * @param prod --商品条件参数
	 * @param cate --类型条件参数
	 * @return
	 */
	@RequestMapping(value="/findAllByConditonWithPage",method=RequestMethod.GET)
	public Page<Product> findAllByConditonWithPage(@RequestParam int page,@RequestParam int size,@RequestParam List<String> properties,
			Product prod,Category cate){
		Page<Product>  product=productDao.findAll(new MySpec(prod,cate),new PageRequest(page, size,new Sort(Direction.DESC,properties)));		
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/findAllByConditonWithPage,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return product;
	}
	
	/**
	 * 删除指定商品
	 * @param product
	 */
	@RequestMapping(value="/deleteProduct",method=RequestMethod.GET)
	public void  deleteProduct(@RequestParam Long id){
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/delete,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		productDao.delete(id);
	}
	
	/**
	 * 批量删除指定商品
	 * @param  
	 * @param products
	 */
	@RequestMapping(value="/deleteBatch",method=RequestMethod.GET)
	public void  deleteBatch(@RequestParam Iterable<Product> products){
		ServiceInstance instance=client.getLocalServiceInstance();
		LOGGER.info("/deleteBatch,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		productDao.delete(products);
	}
	
	

	
	/**
	 * 自定义查询方式
	 */
	private class MySpec implements Specification<Product>{
		
		private Product product;
		private Category category;
		
		public MySpec(Product product,Category category) {
			this.product=product;
			this.category=category;
		}		
		@Override
		public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {			
			// 多条件分页查询
			
			Path<Long> productId= root.get("productId");
			Path<String> productName= root.get("productName");
			Path<Float> productPrice=root.get("productPrice");
			Path<Integer> productRest= root.get("productRest");
			Path<Float> productRebate=root.get("productRebate");
			Path<String> productClickCounts=root.get("productClickCounts");
			
			
			query.where(cBuilder.equal(productId, product.getProductId()),
					cBuilder.like(productName, "%"+product.getProductName()+"%"),
					cBuilder.lessThan(productPrice, product.getProductPrice()),			
					cBuilder.lessThan(productRest, product.getProductRest()),
					cBuilder.lessThan(productRebate, product.getProductRebate()),
					cBuilder.greaterThan(productClickCounts, String.valueOf(product.getProductClickCounts()))
					);				
			Path<String> categoryName=root.join("category",JoinType.INNER).get("categoryName");
			return cBuilder.like(categoryName, "%"+category.getCategoryName()+"%");
		}
	}
	
}
}
