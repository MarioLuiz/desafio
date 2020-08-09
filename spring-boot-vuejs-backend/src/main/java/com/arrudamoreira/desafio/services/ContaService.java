package com.arrudamoreira.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.repositories.ContaRepository;
import com.arrudamoreira.desafio.services.exceptions.ObjectNotFoundException;


@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
	}
}
