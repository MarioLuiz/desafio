package com.arrudamoreira.desafio.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.arrudamoreira.desafio.domain.enums.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer tipo;
	private Double valor;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date instante;
	private Integer contaDeDestino;

	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Movimentacao() {
	}

	public Movimentacao(Integer id, TipoMovimentacao tipo, Double valor, Date instante, Integer contaDeDestino, Conta conta) {
		super();
		this.id = id;
		this.tipo = (tipo == null) ? null : tipo.getTipo();
		this.valor = valor;
		this.instante = instante;
		this.contaDeDestino = contaDeDestino;
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Integer getContaDeDestino() {
		return contaDeDestino;
	}

	public void setContaDeDestino(Integer contaDeDestino) {
		this.contaDeDestino = contaDeDestino;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
