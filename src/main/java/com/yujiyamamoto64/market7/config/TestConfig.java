package com.yujiyamamoto64.market7.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yujiyamamoto64.market7.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean InstantiateDatabase() throws ParseException {
		
		dbService.InstantiateTestDatabase();
		
		return true;
	}
}
