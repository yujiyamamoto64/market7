package com.yujiyamamoto64.market7.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.market7.domain.Category;
import com.yujiyamamoto64.market7.repositories.CategoryRepository;
import com.yujiyamamoto64.market7.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;

	public Category findById(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
				+ ", Type: " + Category.class.getName()));
	}
}
