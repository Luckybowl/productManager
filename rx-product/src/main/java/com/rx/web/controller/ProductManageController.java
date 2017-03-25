package com.rx.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rx.model.dto.Product;
import com.rx.service.ProductService;


@Controller
public class ProductManageController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/findAll")
    public String findAllProduct(HttpServletRequest req, Model model) {
        List<Product> lst = productService.findAll();
        model.addAttribute("productList", lst);
        return "product";
    }
	
}
