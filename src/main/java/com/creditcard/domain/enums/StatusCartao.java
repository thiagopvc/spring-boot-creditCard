package com.creditcard.domain.enums;

public enum StatusCartao {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo");
	
	private Integer cod;
	private String descricao;
	
	private StatusCartao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusCartao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusCartao x : StatusCartao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
