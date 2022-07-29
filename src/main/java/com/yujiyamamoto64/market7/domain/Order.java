package com.yujiyamamoto64.market7.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instant;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "shipAddress_id")
	private Address shipAddress;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {
	}

	public Order(Integer id, Date instant, Client client, Address shipAddress) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.shipAddress = shipAddress;
	}
	
	public double getTotalValue() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum = sum + item.getSubTotal();
		}
		return sum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return instant;
	}

	public void setDate(Date instant) {
		this.instant = instant;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(Address shipAddress) {
		this.shipAddress = shipAddress;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Order number: ");
		builder.append(getId());
		builder.append(", moment: ");
		builder.append(sdf.format(getDate()));
		builder.append(", Client: ");
		builder.append(getClient().getName());
		builder.append(", payment status: ");
		builder.append(getPayment().getStatus().getDescription());
		builder.append("\nDetails:\n");
		for (OrderItem ip : getItems()) {
			builder.append(ip.toString());
		}
		builder.append("Total value: ");
		builder.append(getTotalValue());
		return builder.toString();
	}
	
	
}
