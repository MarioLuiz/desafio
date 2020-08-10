package com.arrudamoreira.desafio.dto;

import java.io.Serializable;

import com.arrudamoreira.desafio.domain.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer numero;
	private String responsavel;
	private Double saldo;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.responsavel = obj.getResponsavel();
		this.saldo = obj.getSaldo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroConta() {
		return numero;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numero = numeroConta;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
