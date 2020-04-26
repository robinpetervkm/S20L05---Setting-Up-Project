package com.norha.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.norha.spring.DAO.AppDAOImpl;

@Configuration
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver" );
		dataSource.setUrl("jdbc:mysql://localhost:3306/project");
		dataSource.setUsername("testuser");
		dataSource.setPassword("test");
		return dataSource;
	}
	
	public AppDAOImpl AppDAO() {
		return new AppDAOImpl(getDataSource());
	}
}


