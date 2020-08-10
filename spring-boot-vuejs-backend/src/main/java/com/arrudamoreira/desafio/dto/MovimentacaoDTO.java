package com.arrudamoreira.desafio.dto;

import java.io.Serializable;
import java.util.Date;

import com.arrudamoreira.desafio.domain.Movimentacao;
import com.arrudamoreira.desafio.domain.enums.TipoMovimentacao;

public class MovimentacaoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private TipoMovimentacao tipo;
	private Double valor;
	private Date instante;
	private Integer contaDeDestino;
	
	
	public MovimentacaoDTO() {
	}
	
	public MovimentacaoDTO(Movimentacao obj) {
		super();
		this.id = obj.getId();
		this.tipo = TipoMovimentacao.toEnum(obj.getTipo());
		this.valor = obj.getValor();
		this.instante = obj.getInstante();
		this.contaDeDestino = obj.getContaDeDestino();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
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
}
