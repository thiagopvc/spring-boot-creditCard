package com.creditcard.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.domain.ContaCartao;
import com.creditcard.services.ContaCartaoService;


@RestController
@RequestMapping(value="/cartoes")
public class ContaCartaoResource {

	@Autowired
	private ContaCartaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ContaCartao obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
