package com.primeton.ranxing.productapi.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.ranxing.productapi.entity.Product;
import com.primeton.ranxing.productapi.server.IProduct;

@RestController
@RequestMapping(value = "/api")
public class PController {

	@Autowired
	IProduct productServer;


	@SuppressWarnings("unchecked")
	@RequestMapping(value="/products",method = RequestMethod.GET)
	Iterable<Product> getProducts(@RequestParam("name") String name,@RequestParam("ID") Long pId){
		List<Product> returnData = new ArrayList<Product>();
		@SuppressWarnings("unused")
		Product product = null;
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(pId)){
			return productServer.findAllProduct();
		}else if(StringUtils.isEmpty(name)){
			returnData.add(productServer.getProductByName(name));
		} else if(StringUtils.isEmpty(pId)){
			returnData.add(productServer.findOne(pId));
		}
		return ((Iterable<Product>) returnData.iterator());
		
	}
	
	@RequestMapping(value="/products/{id}",method = RequestMethod.GET)
	Product findById(@PathVariable("id") Long id){
		return productServer.findOne(id);
	}
	

	@RequestMapping(value = "/products/{id}",method=RequestMethod.DELETE)
	String deleteProduct(@PathVariable("id") long id){
		Product product = productServer.findOne(id);	//找出对应id的商品
		productServer.delete(product);			//删除对应商品
		return "{\"status\":\"OK\"}";
	}
}
