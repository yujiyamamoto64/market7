package com.yujiyamamoto64.market7.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yujiyamamoto64.market7.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean InstantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		dbService.InstantiateTestDatabase();
		
		return true;
	}
}
