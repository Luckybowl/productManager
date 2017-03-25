package com.rx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rx.model.dto.Product;

@Service
public class ProductService {

	public List<Product> findAll() {
		List<Product> lst = new ArrayList<Product>();
		Product p = new Product();

		p.setProductId(1L);
		p.setProductName("rxProductName");
		p.setProductDesc("desc");
		p.setProductPrice(2.35f);
		p.setProductTotal(20);
		p.setProductRest(5);
		p.setProductRebate(2.3f);
		p.setProductClickCounts(5);
		p.setProductPicturePath("path");

		lst.add(p);
		return lst;

	}

}
