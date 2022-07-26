package com.yujiyamamoto64.market7.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.yujiyamamoto64.market7.domain.Category;
import com.yujiyamamoto64.market7.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Transactional(readOnly = true)
	Page<Product> findDistinctByNameContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageRequest);
	
	/*
	 * Another alternative: 
	 * @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat IN :categories")
	 * Page<Product> search(@Param("name") String name,@Param("categories") List<Category> categories, Pageable pageRequest);
	 */
}
