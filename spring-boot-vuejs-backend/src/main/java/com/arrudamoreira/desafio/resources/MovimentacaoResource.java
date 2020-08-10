package com.arrudamoreira.desafio.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.desafio.domain.Movimentacao;
import com.arrudamoreira.desafio.dto.MovimentacaoDTO;
import com.arrudamoreira.desafio.services.MovimentacaoService;

@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoResource {
	
	@Autowired
	private MovimentacaoService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Movimentacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MovimentacaoDTO>> findAll() {
		List<Movimentacao> list = service.findAll();
		List<MovimentacaoDTO> listDto = list.stream().map(obj -> new MovimentacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
