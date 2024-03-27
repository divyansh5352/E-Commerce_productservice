package com.scaler.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ProductserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
