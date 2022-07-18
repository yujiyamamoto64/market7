package com.yujiyamamoto64.market7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yujiyamamoto64.market7.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
