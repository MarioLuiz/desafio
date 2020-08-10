package com.arrudamoreira.desafio.domain.enums;

public enum TipoMovimentacao {
	
	DEPOSITO(1, "Deposito"),
	SAQUE(2, "Saque"),
	TRANSFERENCIA(3, "Tranferencia");
	
	private int tipo;
	private String descricao;
	
	private TipoMovimentacao(int tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoMovimentacao toEnum(Integer tipo) {
		if(tipo == null) {
			return null;
		}
		
		for(TipoMovimentacao x : TipoMovimentacao.values()) {
			if(tipo.equals(x.getTipo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + tipo);
	}
}
