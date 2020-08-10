package com.arrudamoreira.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.domain.Movimentacao;
import com.arrudamoreira.desafio.repositories.MovimentacaoRepository;
import com.arrudamoreira.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repo;
	
	public Movimentacao find(Integer id){
		Optional<Movimentacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
	}
	
	public Movimentacao insert(Movimentacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Movimentacao> findAll() {
		return repo.findAll();
	}
}
