package com.yujiyamamoto64.market7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.State;
import com.yujiyamamoto64.market7.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repo;

	public List<State> findAll() {
		return repo.findAllByOrderByName();
	}
}
