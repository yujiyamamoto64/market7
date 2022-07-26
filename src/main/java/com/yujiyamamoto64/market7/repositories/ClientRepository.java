package com.yujiyamamoto64.market7.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yujiyamamoto64.market7.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Transactional
	Client findByEmail(String email);
}
