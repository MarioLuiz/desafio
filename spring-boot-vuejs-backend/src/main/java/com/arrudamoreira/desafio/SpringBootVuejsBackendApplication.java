package com.arrudamoreira.desafio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.repositories.ContaRepository;

@SpringBootApplication
public class SpringBootVuejsBackendApplication implements CommandLineRunner{
	
	@Autowired
	private ContaRepository contaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Conta conta1 = new Conta(null, 107597, "Luiz Carlos da Silva", 1800.00);
		Conta conta2 = new Conta(null, 108892, "Marina Germenes Lucida", 7894.00);
		Conta conta3 = new Conta(null, 107597, "Rafaela do Santos Barbosa", 8568.70);
		
		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
		
	}

}
