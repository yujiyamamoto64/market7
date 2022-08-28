package com.yujiyamamoto64.market7.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.yujiyamamoto64.market7.domain.enums.Role;
import com.yujiyamamoto64.market7.repositories.AddressRepository;
import com.yujiyamamoto64.market7.repositories.CategoryRepository;
import com.yujiyamamoto64.market7.repositories.CityRepository;
import com.yujiyamamoto64.market7.repositories.ClientRepository;
import com.yujiyamamoto64.market7.repositories.OrderItemRepository;
import com.yujiyamamoto64.market7.repositories.OrderRepository;
import com.yujiyamamoto64.market7.repositories.PaymentRepository;
import com.yujiyamamoto64.market7.repositories.ProductRepository;
import com.yujiyamamoto64.market7.repositories.StateRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
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

	public void InstantiateTestDatabase() throws ParseException {
		
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
		Product p4 = new Product(null, "Office desk", 300.00);
		Product p5 = new Product(null, "Towel", 50.00);
		Product p6 = new Product(null, "Quilt", 200.00);
		Product p7 = new Product(null, "TV true color", 1200.00);
		Product p8 = new Product(null, "Brushcutter", 800.00);
		Product p9 = new Product(null, "Beside lamp", 100.00);
		Product p10 = new Product(null, "Pending", 180.00);
		Product p11= new Product(null, "Shampoo", 90.00);
		Product p12 = new Product(null, "Product 12", 10.00);
		Product p13 = new Product(null, "Product 13", 10.00);
		Product p14 = new Product(null, "Product 14", 10.00);
		Product p15 = new Product(null, "Product 15", 10.00);
		Product p16 = new Product(null, "Product 16", 10.00);
		Product p17 = new Product(null, "Product 17", 10.00);
		Product p18 = new Product(null, "Product 18", 10.00);
		Product p19 = new Product(null, "Product 19", 10.00);
		Product p20 = new Product(null, "Product 20", 10.00);
		Product p21 = new Product(null, "Product 21", 10.00);
		Product p22 = new Product(null, "Product 22", 10.00);
		Product p23 = new Product(null, "Product 23", 10.00);
		Product p24 = new Product(null, "Product 24", 10.00);
		Product p25 = new Product(null, "Product 25", 10.00);
		Product p26 = new Product(null, "Product 26", 10.00);
		Product p27 = new Product(null, "Product 27", 10.00);
		Product p28 = new Product(null, "Product 28", 10.00);
		Product p29 = new Product(null, "Product 29", 10.00);
		Product p30 = new Product(null, "Product 30", 10.00);
		Product p31 = new Product(null, "Product 31", 10.00);
		Product p32 = new Product(null, "Product 32", 10.00);
		Product p33 = new Product(null, "Product 33", 10.00);
		Product p34 = new Product(null, "Product 34", 10.00);
		Product p35 = new Product(null, "Product 35", 10.00);
		Product p36 = new Product(null, "Product 36", 10.00);
		Product p37 = new Product(null, "Product 37", 10.00);
		Product p38 = new Product(null, "Product 38", 10.00);
		Product p39 = new Product(null, "Product 39", 10.00);
		Product p40 = new Product(null, "Product 40", 10.00);
		Product p41 = new Product(null, "Product 41", 10.00);
		Product p42 = new Product(null, "Product 42", 10.00);
		Product p43 = new Product(null, "Product 43", 10.00);
		Product p44 = new Product(null, "Product 44", 10.00);
		Product p45 = new Product(null, "Product 45", 10.00);
		Product p46 = new Product(null, "Product 46", 10.00);
		Product p47 = new Product(null, "Product 47", 10.00);
		Product p48 = new Product(null, "Product 48", 10.00);
		Product p49 = new Product(null, "Product 49", 10.00);
		Product p50 = new Product(null, "Product 50", 10.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3, p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
		
		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));
		p12.getCategories().add(cat1);
		p13.getCategories().add(cat1);
		p14.getCategories().add(cat1);
		p15.getCategories().add(cat1);
		p16.getCategories().add(cat1);
		p17.getCategories().add(cat1);
		p18.getCategories().add(cat1);
		p19.getCategories().add(cat1);
		p20.getCategories().add(cat1);
		p21.getCategories().add(cat1);
		p22.getCategories().add(cat1);
		p23.getCategories().add(cat1);
		p24.getCategories().add(cat1);
		p25.getCategories().add(cat1);
		p26.getCategories().add(cat1);
		p27.getCategories().add(cat1);
		p28.getCategories().add(cat1);
		p29.getCategories().add(cat1);
		p30.getCategories().add(cat1);
		p31.getCategories().add(cat1);
		p32.getCategories().add(cat1);
		p33.getCategories().add(cat1);
		p34.getCategories().add(cat1);
		p35.getCategories().add(cat1);
		p36.getCategories().add(cat1);
		p37.getCategories().add(cat1);
		p38.getCategories().add(cat1);
		p39.getCategories().add(cat1);
		p40.getCategories().add(cat1);
		p41.getCategories().add(cat1);
		p42.getCategories().add(cat1);
		p43.getCategories().add(cat1);
		p44.getCategories().add(cat1);
		p45.getCategories().add(cat1);
		p46.getCategories().add(cat1);
		p47.getCategories().add(cat1);
		p48.getCategories().add(cat1);
		p49.getCategories().add(cat1);
		p50.getCategories().add(cat1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		State st1 = new State(null, "Sao Paulo");
		State st2 = new State(null, "Minas Gerais");
		
		City c1 = new City(null, "Uberlandia", st2);
		City c2 = new City(null, "Sao Paulo", st1);
		City c3 = new City(null, "Campinas", st1);
		
		st2.getCities().add(c1);
		st1.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		// just changing maria email to myself email to test email send method
		Client cli1 = new Client(null, "Maria Silva", "yujiyamamoto64@gmail.com", "36378912377", ClientType.PESSOAFISICA, pe.encode("123"));
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		Client cli2 = new Client(null, "Ana Costa", "anac@gmail.com", "86774274064", ClientType.PESSOAFISICA, pe.encode("123"));
		cli2.addRole(Role.ADMIN);
		cli2.getPhones().addAll(Arrays.asList("4879875", "4897589347"));
		
		Address e1 = new Address(null, "Rua Flores", "300", "Apto 300", "Jardim", "38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Address e3 = new Address(null, "Avenida floriano", "2106", null, "Centro", "281777012", cli2, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		cli2.getAddresses().addAll(Arrays.asList(e3));
		
		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(e1, e2, e3));
		
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
