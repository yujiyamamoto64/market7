package com.yujiyamamoto64.market7.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujiyamamoto64.market7.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public List<Category> list() {
		Category cat1 = new Category(1, "Informatic");
		Category cat2 = new Category(2, "Office");
		List<Category> list = new ArrayList<>();
		list.addAll(Arrays.asList(cat1, cat2));
		return list;
	}
}