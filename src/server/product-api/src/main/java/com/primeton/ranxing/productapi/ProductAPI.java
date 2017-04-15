package com.primeton.ranxing.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * feign 实现RESTful 接口
 * @author linjx
 * @time 2017-04-15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductAPI {
	public static void main(String[] args) {
		SpringApplication.run(ProductAPI.class, args);
	}
}
