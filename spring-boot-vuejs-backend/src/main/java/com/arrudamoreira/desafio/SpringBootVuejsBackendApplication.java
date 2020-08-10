package com.arrudamoreira.desafio;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.domain.Movimentacao;
import com.arrudamoreira.desafio.domain.enums.TipoMovimentacao;
import com.arrudamoreira.desafio.repositories.ContaRepository;
import com.arrudamoreira.desafio.repositories.MovimentacaoRepository;

@SpringBootApplication
public class SpringBootVuejsBackendApplication implements CommandLineRunner{
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Conta conta1 = new Conta(null, 107597, "Luiz Carlos da Silva", 1800.00);
		Conta conta2 = new Conta(null, 108892, "Marina Germenes Lucida", 7894.00);
		Conta conta3 = new Conta(null, 107597, "Rafaela do Santos Barbosa", 8568.70);
		
		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
		
		Movimentacao mov1 = new Movimentacao(null, TipoMovimentacao.DEPOSITO, 500.00, new Date(), null, conta1);
		Movimentacao mov2 = new Movimentacao(null, TipoMovimentacao.SAQUE, 600.00, new Date(), null, conta1);
		Movimentacao mov3 = new Movimentacao(null, TipoMovimentacao.DEPOSITO, 780.00, new Date(), null, conta2);
		Movimentacao mov4 = new Movimentacao(null, TipoMovimentacao.SAQUE, 100.00, new Date(), null, conta2);
		Movimentacao mov5 = new Movimentacao(null, TipoMovimentacao.DEPOSITO, 150.00, new Date(), null, conta3);
		Movimentacao mov6 = new Movimentacao(null, TipoMovimentacao.SAQUE, 300.00, new Date(), null, conta3);
		
		movimentacaoRepository.saveAll(Arrays.asList(mov1, mov2, mov3, mov4, mov5, mov6));
		
	}

}
