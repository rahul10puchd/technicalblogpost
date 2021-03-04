package com.upgrad.technicalblogpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TechnicalBlogPostApplication {
	public TechnicalBlogPostApplication(){
		System.out.println("*********** TechnicalBlogPostApplication ***********");
	}
	public static void main(String[] args) {
		SpringApplication.run(TechnicalBlogPostApplication.class, args);
	}
}
