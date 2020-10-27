package com.creditcard.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.domain.Transacao;
import com.creditcard.repositories.TransacaoRepository;
import com.creditcard.services.exception.ObjectNotFoundException;


@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repo;
	
	public Transacao buscar(Integer id) {
		
		Optional<Transacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Transacao.class.getName()));
	}
}