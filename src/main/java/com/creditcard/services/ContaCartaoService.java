package com.creditcard.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.domain.ContaCartao;
import com.creditcard.repositories.ContaCartaoRepository;
import com.creditcard.services.exception.ObjectNotFoundException;


@Service
public class ContaCartaoService {

	@Autowired
	private ContaCartaoRepository repo;
	
	public ContaCartao buscar(Integer id) {
		
		Optional<ContaCartao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ContaCartao.class.getName()));
	}
}