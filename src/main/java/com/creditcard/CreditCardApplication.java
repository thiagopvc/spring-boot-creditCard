package com.creditcard;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.creditcard.domain.ContaCartao;
import com.creditcard.domain.Transacao;
import com.creditcard.domain.enums.StatusCartao;
import com.creditcard.repositories.ContaCartaoRepository;
import com.creditcard.repositories.TransacaoRepository;

@SpringBootApplication
public class CreditCardApplication implements CommandLineRunner {
	
	@Autowired
	ContaCartaoRepository contaCartaoRepository;
	
	@Autowired
	TransacaoRepository TransacaoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		ContaCartao cartao1 = new ContaCartao(null, "Visa", 1000.00, StatusCartao.ATIVO);
		ContaCartao cartao2 = new ContaCartao(null, "Master", 500.00, StatusCartao.INATIVO);
		
		Transacao trans1 = new Transacao(null, sdf.parse("22/10/2020 23:11:45"), "Zara", 300.00, cartao1);
		Transacao trans2 = new Transacao(null, sdf.parse("23/10/2020 14:30:30"), "McDonalds", 25.00, cartao2);
		
		cartao1.getTransacoes().addAll(Arrays.asList(trans1));
		cartao2.getTransacoes().addAll(Arrays.asList(trans2));
		
		contaCartaoRepository.saveAll(Arrays.asList(cartao1, cartao2));
		TransacaoRepository.saveAll(Arrays.asList(trans1, trans2));
		
		
		
		
	}

}
