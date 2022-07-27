package com.yujiyamamoto64.market7.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.yujiyamamoto64.market7.domain.enums.PaymentStatus;

@Entity
@JsonTypeName("cardPayment")
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer installmentsNumber;
	
	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentStatus status, Order order, Integer installmentsNumber) {
		super(id, status, order);
		this.installmentsNumber = installmentsNumber;
	}

	public Integer getInstallmentsNumber() {
		return installmentsNumber;
	}

	public void setInstallmentsNumber(Integer installmentsNumber) {
		this.installmentsNumber = installmentsNumber;
	}
	
}
