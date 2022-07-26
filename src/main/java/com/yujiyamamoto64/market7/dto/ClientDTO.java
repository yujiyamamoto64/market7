package com.yujiyamamoto64.market7.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.yujiyamamoto64.market7.domain.Client;
import com.yujiyamamoto64.market7.services.validations.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Cannot be null")
	@Length(min=5, max=120, message = "Must have 5 to 120 characters")
	private String name;
	
	@NotEmpty(message = "Cannot be null")
	@Length(message = "Invalid email")
	private String email;
	
	public ClientDTO() {
	}

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
