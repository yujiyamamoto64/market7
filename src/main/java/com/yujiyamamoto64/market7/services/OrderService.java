package com.yujiyamamoto64.market7.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yujiyamamoto64.market7.domain.BoletoPayment;
import com.yujiyamamoto64.market7.domain.Order;
import com.yujiyamamoto64.market7.domain.OrderItem;
import com.yujiyamamoto64.market7.domain.enums.PaymentStatus;
import com.yujiyamamoto64.market7.repositories.OrderItemRepository;
import com.yujiyamamoto64.market7.repositories.OrderRepository;
import com.yujiyamamoto64.market7.repositories.PaymentRepository;
import com.yujiyamamoto64.market7.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmailService emailService;

	public Order findById(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
				+ ", Type: " + Order.class.getName()));
	}
	
	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setDate(new Date());
		obj.setClient(clientService.findById(obj.getClient().getId()));
		obj.getPayment().setStatus(PaymentStatus.WAITING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof BoletoPayment) {
			BoletoPayment pagto = (BoletoPayment) obj.getPayment();
			boletoService.fillBoletoPayment(pagto, obj.getDate());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (OrderItem item : obj.getItems()) {
			item.setDiscount(0.0);
			item.setProduct(productService.findById(item.getProduct().getId()));
			item.setPrice(productService.findById(item.getProduct().getId())
					.getPrice());
			item.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItems());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
}
