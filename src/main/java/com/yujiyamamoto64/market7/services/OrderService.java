package com.yujiyamamoto64.market7.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.Order;
import com.yujiyamamoto64.market7.repositories.OrderRepository;
import com.yujiyamamoto64.market7.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public Order findById(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
				+ ", Type: " + Order.class.getName()));
	}
}
