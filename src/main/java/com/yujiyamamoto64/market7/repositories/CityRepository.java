package com.yujiyamamoto64.market7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yujiyamamoto64.market7.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM City obj WHERE obj.states.id = :stateId ORDER BY obj.name")
	public List<City> findCities(@Param("stateId") Integer state_id);
}
