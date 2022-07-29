package com.yujiyamamoto64.market7.services;

import org.springframework.mail.SimpleMailMessage;

import com.yujiyamamoto64.market7.domain.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
