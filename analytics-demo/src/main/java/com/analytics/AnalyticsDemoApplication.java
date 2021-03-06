package com.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AnalyticsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsDemoApplication.class, args);
	}

}
