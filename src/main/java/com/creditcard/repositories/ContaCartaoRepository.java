package com.creditcard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.domain.ContaCartao;

@Repository
public interface ContaCartaoRepository extends JpaRepository<ContaCartao, Integer> {
	
}