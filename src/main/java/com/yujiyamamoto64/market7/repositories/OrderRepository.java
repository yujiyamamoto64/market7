package com.yujiyamamoto64.market7.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yujiyamamoto64.market7.domain.Client;
import com.yujiyamamoto64.market7.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	Page<Order> findByClient(Client client, Pageable pageRequest);
}
