package com.greenjava.bookdetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.greenjava.bookdetailsservice")
public class BookDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDetailsServiceApplication.class, args);
	}

}
