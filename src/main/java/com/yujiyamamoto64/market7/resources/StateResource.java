package com.yujiyamamoto64.market7.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujiyamamoto64.market7.domain.City;
import com.yujiyamamoto64.market7.domain.State;
import com.yujiyamamoto64.market7.dto.CityDTO;
import com.yujiyamamoto64.market7.dto.StateDTO;
import com.yujiyamamoto64.market7.services.CityService;
import com.yujiyamamoto64.market7.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateResource {
	
	@Autowired
	private StateService service;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<StateDTO>> findAll() {
		List<State> list = service.findAll();
		List<StateDTO> listDto = list.stream().map(obj -> new StateDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{stateId}/cities")
	public ResponseEntity<List<CityDTO>> findCities (@PathVariable Integer stateId) {
		List<City> list = cityService.findByState(stateId);
		List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
