package com.yujiyamamoto64.market7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.City;
import com.yujiyamamoto64.market7.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	
	public List<City> findByState(Integer state_id) {
		return repo.findCities(state_id);
	}
}
