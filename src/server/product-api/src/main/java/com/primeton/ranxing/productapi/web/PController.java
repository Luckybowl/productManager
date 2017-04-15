package com.primeton.ranxing.productapi.web;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	String addProduct(Product p) {
		if (productServer.addProduct(p) == 1) {
			// 添加成功
			return productServer.findOne(p.getProductId()).toString();
		} else {
			return "{\"error\": \"add failed\"}";
		}
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	Iterable<Product> getProducts() {
		return productServer.findAllProduct();

	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	Product findById(@PathVariable("id") Long id) {
		return productServer.findOne(id);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	String deleteProduct(@PathVariable("id") long id) {
		Product product = productServer.findOne(id); // 找出对应id的商品
		productServer.delete(product); // 删除对应商品
		return "{\"status\":\"OK\"}";
	}
}
