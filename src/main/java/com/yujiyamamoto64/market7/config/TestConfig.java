package com.yujiyamamoto64.market7.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yujiyamamoto64.market7.services.DBService;
import com.yujiyamamoto64.market7.services.EmailService;
import com.yujiyamamoto64.market7.services.SmtpEmailService;

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
	
	/*
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	} 
	*/
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
