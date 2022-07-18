package com.yujiyamamoto64.market7;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yujiyamamoto64.market7.domain.Category;
import com.yujiyamamoto64.market7.domain.City;
import com.yujiyamamoto64.market7.domain.Product;
import com.yujiyamamoto64.market7.domain.State;
import com.yujiyamamoto64.market7.repositories.CategoryRepository;
import com.yujiyamamoto64.market7.repositories.CityRepository;
import com.yujiyamamoto64.market7.repositories.ProductRepository;
import com.yujiyamamoto64.market7.repositories.StateRepository;

@SpringBootApplication
public class Market7Application implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Market7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Printer", 800.00);
		Product p2 = new Product(null, "Computer", 2000.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().add(cat1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State st1 = new State(null, "Sao Paulo");
		State st2 = new State(null, "Minas Gerais");
		
		City c1 = new City(null, "Uberlandia", st1);
		City c2 = new City(null, "Sao Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().add(c1);
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
