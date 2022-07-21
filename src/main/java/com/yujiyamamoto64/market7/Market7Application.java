package com.yujiyamamoto64.market7;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yujiyamamoto64.market7.domain.Address;
import com.yujiyamamoto64.market7.domain.BoletoPayment;
import com.yujiyamamoto64.market7.domain.CardPayment;
import com.yujiyamamoto64.market7.domain.Category;
import com.yujiyamamoto64.market7.domain.City;
import com.yujiyamamoto64.market7.domain.Client;
import com.yujiyamamoto64.market7.domain.Order;
import com.yujiyamamoto64.market7.domain.OrderItem;
import com.yujiyamamoto64.market7.domain.Payment;
import com.yujiyamamoto64.market7.domain.Product;
import com.yujiyamamoto64.market7.domain.State;
import com.yujiyamamoto64.market7.domain.enums.ClientType;
import com.yujiyamamoto64.market7.domain.enums.PaymentStatus;
import com.yujiyamamoto64.market7.repositories.AddressRepository;
import com.yujiyamamoto64.market7.repositories.CategoryRepository;
import com.yujiyamamoto64.market7.repositories.CityRepository;
import com.yujiyamamoto64.market7.repositories.ClientRepository;
import com.yujiyamamoto64.market7.repositories.OrderItemRepository;
import com.yujiyamamoto64.market7.repositories.OrderRepository;
import com.yujiyamamoto64.market7.repositories.PaymentRepository;
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
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Market7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		Category cat3 = new Category(null, "Bed, table and bath");
		Category cat4 = new Category(null, "Eletronics");
		Category cat5 = new Category(null, "Garden");
		Category cat6 = new Category(null, "Decoration");
		Category cat7 = new Category(null, "Perfumery");
		
		Product p1 = new Product(null, "Printer", 800.00);
		Product p2 = new Product(null, "Computer", 2000.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().add(cat1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
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
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address e1 = new Address(null, "Rua Flores", "300", "Apto 300", "Jardim", "38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		
		clientRepository.save(cli1);
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Order ped2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.PAID, ped1, 6);
		ped1.setPayment(pay1);
		
		Payment pay2 = new BoletoPayment(null, PaymentStatus.WAITING, 
				ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));
		
		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 1, 80.00);
		OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().add(ip3);
		
		p1.getItems().add(ip1);
		p2.getItems().add(ip3);
		p3.getItems().add(ip2);
		
		orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
