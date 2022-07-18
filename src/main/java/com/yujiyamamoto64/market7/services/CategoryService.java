package com.yujiyamamoto64.market7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.Category;
import com.yujiyamamoto64.market7.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;

	public Category findById(Integer id) {
		Category obj = repo.findById(id).orElse(null);
		return obj;
	}
}
