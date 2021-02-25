package com.upgrad.technicalblogpost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    public JpaConfig(){
        System.out.println("*********** JpaConfig ***********");
    }
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
        emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        emfb.afterPropertiesSet();
        return  emfb.getObject();
    }
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.postgresql.Driver");
//        ds.setUrl("localhost:5645/qwqwq");
//        ds.setPassword("qqqqq");
//        ds.setUsername("ewewewe");
//        return ds;
//    }

}
