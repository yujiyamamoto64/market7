package com.yujiyamamoto64.market7.domain.enums;

public enum Role {

	ADMIN(1, "ROLE_ADMIN"), CLIENT(2, "RLE_CLIENT");

	private int cod;
	private String description;

	private Role(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCode() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Role toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Role x : Role.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + cod);
	}
}
