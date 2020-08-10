package com.arrudamoreira.desafio.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.dto.ContaDTO;
import com.arrudamoreira.desafio.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@Autowired
	private ContaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Conta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody ContaDTO objDto) {
		Conta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity <Void> update(@RequestBody ContaDTO objDto, @PathVariable Integer id){
		Conta obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/{valor}/deposito", method = RequestMethod.PUT)
	public ResponseEntity <Void> updateDeposito(@PathVariable Integer id, @PathVariable Double valor){
		Conta obj = service.find(id);
		obj = service.updateMovimentacaoDeposito(obj, valor);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/{valor}/saque", method = RequestMethod.PUT)
	public ResponseEntity <Void> updateSaque(@PathVariable Integer id, @PathVariable Double valor){
		Conta obj = service.find(id);
		obj = service.updateMovimentacaoSaque(obj, valor);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/{valor}/{numeroContaDestino}", method = RequestMethod.PUT)
	public ResponseEntity <Void> updateSaque(@PathVariable Integer id, @PathVariable Double valor,@PathVariable Integer numeroContaDestino){
		Conta obj = service.find(id);
		obj = service.updateMovimentacaoSaque(obj, valor);
		return ResponseEntity.noContent().build();
	}
}
