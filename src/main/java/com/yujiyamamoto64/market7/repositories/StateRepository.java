package com.yujiyamamoto64.market7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.yujiyamamoto64.market7.domain.State;

public interface StateRepository extends JpaRepository<State, Integer>{

	@Transactional(readOnly = true)
	public List<State> findAllByOrderByName();
}
