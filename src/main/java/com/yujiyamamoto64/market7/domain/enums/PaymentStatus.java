package com.yujiyamamoto64.market7.domain.enums;

public enum PaymentStatus {

	WAITING(1, "Pendente"),
	PAID(2, "Quitado"),
	CANCELED(3, "Cancelado");
	
	private int cod;
	private String description;
	
	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCode() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PaymentStatus x : PaymentStatus.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: " + cod);
	}
}
