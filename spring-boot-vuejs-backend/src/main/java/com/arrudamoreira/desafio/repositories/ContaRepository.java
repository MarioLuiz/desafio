package com.arrudamoreira.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrudamoreira.desafio.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
