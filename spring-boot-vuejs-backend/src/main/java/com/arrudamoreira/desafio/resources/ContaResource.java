package com.arrudamoreira.desafio.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.desafio.domain.Conta;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Conta> listar() {
		
		Conta conta1 = new Conta(1, 107597, "Luiz Carlos da Silva", 1800.00);
		Conta conta2 = new Conta(2, 108892, "Marina Germenes Lucida", 7894.00);
		Conta conta3 = new Conta(1, 107597, "Rafaela do Santos Barbosa", 8568.70);
		
		List<Conta> contas = new ArrayList<>();
		
		contas.addAll(Arrays.asList(conta1,conta2,conta3));
		
		return contas;
	}
}
