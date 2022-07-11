package com.yujiyamamoto64.market7.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public String list() {
		return "rest's working";
	}
}
