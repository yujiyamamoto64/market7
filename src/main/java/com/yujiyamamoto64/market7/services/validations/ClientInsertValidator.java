package com.yujiyamamoto64.market7.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.yujiyamamoto64.market7.domain.Client;
import com.yujiyamamoto64.market7.domain.enums.ClientType;
import com.yujiyamamoto64.market7.dto.ClientNewDTO;
import com.yujiyamamoto64.market7.repositories.ClientRepository;
import com.yujiyamamoto64.market7.resources.exceptions.FieldMessage;
import com.yujiyamamoto64.market7.services.validations.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO>{

	@Autowired
	private ClientRepository repo;
	
	@Override
	public void initialize(ClientInsert ann) {
	}
	
	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getType().equals(ClientType.PESSOAFISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CPF"));
		}
		
		if (objDto.getType().equals(ClientType.PESSOAJURIDICA.getCode()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CNPJ"));
		}
		
		Client aux = repo.findByEmail(objDto.getEmail());
		if ( aux != null ) {
			list.add(new FieldMessage("email", "Email already exists"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getFieldName())
			.addConstraintViolation();
		}
		return list.isEmpty();
	}
	
}
