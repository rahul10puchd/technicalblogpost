package com.upgrad.technicalblogpost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket technicalBlogDocument() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.upgrad.technicalblogpost.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        ApiInfo info = new ApiInfo(
                "SPINGBOOT REST API PROJECT",
                "SpringBoot Project for TechnicalBlogPost",
                "1.0",
                "Terms of Service",
                new Contact("Upgrad", "http://upgrad.edu", "rajat.dey@upgrad.com"),
                "Apache Liscense Version 2.0",
                "http://apache.com"
        );
        return info;
    }
}
