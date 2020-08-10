package com.arrudamoreira.desafio.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.desafio.domain.Conta;
import com.arrudamoreira.desafio.domain.Movimentacao;
import com.arrudamoreira.desafio.domain.enums.TipoMovimentacao;
import com.arrudamoreira.desafio.dto.ContaDTO;
import com.arrudamoreira.desafio.repositories.ContaRepository;
import com.arrudamoreira.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;

	@Autowired
	private MovimentacaoService movimentacaoService;

	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
	}

	public Conta insert(Conta obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Conta update(Conta obj) {
		Conta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public Conta updateMovimentacaoDeposito(Conta obj, Double valorDeposito) {
		Optional<Conta> newObj = repo.findById(obj.getId());
		if (valorDeposito > 0.00) {
			newObj.get().setSaldo(newObj.get().getSaldo() + valorDeposito);
			Movimentacao movimentacaoDeposito = new Movimentacao(null, TipoMovimentacao.DEPOSITO, valorDeposito,
					new Date(), null, newObj.get());
			movimentacaoService.insert(movimentacaoDeposito);
			newObj.get().getMovimentacoes().add(movimentacaoDeposito);
		} else {
			return newObj.orElseThrow(() -> new ObjectNotFoundException(
					"Valor de deposito invalido: " + valorDeposito + ", Tipo: " + Conta.class.getName()));
		}
		return repo.save(newObj.get());
	}

	public Conta updateMovimentacaoSaque(Conta obj, Double valorSaque) {
		Optional<Conta> newObj = repo.findById(obj.getId());
		if (newObj.get().getSaldo() > valorSaque) {
			newObj.get().setSaldo(newObj.get().getSaldo() - valorSaque);
			Movimentacao movimentacaoSaque = new Movimentacao(null, TipoMovimentacao.SAQUE, valorSaque, new Date(),
					null, newObj.get());
			movimentacaoService.insert(movimentacaoSaque);
			newObj.get().getMovimentacoes().add(movimentacaoSaque);
		} else {
			return newObj.orElseThrow(() -> new ObjectNotFoundException(
					"Valor de saque invalido, saldo insuficiente: " + valorSaque + ", Tipo: " + Conta.class.getName()));
		}
		return repo.save(newObj.get());
	}

	public Conta updateMovimentacaoTransferencia(Conta obj, Double valorDeTransferencia, Integer numeroContaDestino) {
		Optional<Conta> newObj = repo.findById(obj.getId());
		if (newObj.get().getSaldo() > valorDeTransferencia) {
			newObj.get().setSaldo(newObj.get().getSaldo() - valorDeTransferencia);
			Movimentacao movimentacaoTransferencia = new Movimentacao(null, TipoMovimentacao.TRANSFERENCIA,
					valorDeTransferencia, new Date(), numeroContaDestino, newObj.get());
			movimentacaoService.insert(movimentacaoTransferencia);
			newObj.get().getMovimentacoes().add(movimentacaoTransferencia);
		} else {
			return newObj.orElseThrow(() -> new ObjectNotFoundException("Saldo invalido, saldo insuficiente: "
					+ valorDeTransferencia + ", Tipo: " + Conta.class.getName()));
		}
		return repo.save(newObj.get());
	}

	public Conta fromDTO(ContaDTO objDto) {
		return new Conta(objDto.getId(), objDto.getNumeroConta(), objDto.getResponsavel(), objDto.getSaldo());
	}

	private void updateData(Conta newObj, Conta obj) {
		newObj.setResponsavel(obj.getResponsavel());
	}
}
