//package com.example.snomate.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//@Configuration
//@EnableConfigurationProperties
//public class DataSourceProperties {
//
//	@Bean(name = "dataSource")
//	@Primary
//	@ConfigurationProperties("spring.datasource.hikari")
//	public DataSource snoamteDataSource() {
//		return DataSourceBuilder.create().type(HikariDataSource.class).build();
//	}
//
//}