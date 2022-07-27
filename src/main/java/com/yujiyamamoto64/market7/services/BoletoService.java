package com.yujiyamamoto64.market7.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.BoletoPayment;

@Service
public class BoletoService {

	public void fillBoletoPayment(BoletoPayment pagto, Date paymentInstant) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDueDate(cal.getTime());
	}
}
