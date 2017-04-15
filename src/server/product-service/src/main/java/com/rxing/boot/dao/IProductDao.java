package com.rxing.boot.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rxing.boot.entity.Product;

/**
 * 商品服务接口
 * @author wxh
 * 2017年4月15日
 */
public interface IProductDao extends CrudRepository<Product, Long>,PagingAndSortingRepository<Product,Long>,JpaSpecificationExecutor<Product>{
	
	@Query("select t from Product t where t.productName=:product_name")
	Product getProductByName(@Param("product_name") String productName);	
}
