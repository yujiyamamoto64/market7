package com.yujiyamamoto64.market7.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.yujiyamamoto64.market7.domain.Client;
import com.yujiyamamoto64.market7.domain.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Order obj);
	
	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Client client, String newPass);
	
}
