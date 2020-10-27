package com.creditcard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.creditcard.domain.enums.StatusCartao;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ContaCartao {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String bandeira;
	private Double limite;
	private Integer status;
	
	@JsonManagedReference
	@OneToMany(mappedBy="contaCartao")
	private List<Transacao> transacoes = new ArrayList<>();
	
	public ContaCartao() {
	}

	public ContaCartao(Integer id, String bandeira, Double limite, StatusCartao status) {
		super();
		this.id = id;
		this.bandeira = bandeira;
		this.limite = limite;
		this.status = status.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public StatusCartao getStatus() {
		return StatusCartao.toEnum(status);
	}

	public void setStatus(StatusCartao status) {
		this.status = status.getCod();
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCartao other = (ContaCartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
