package com.tinova.cadastroveiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinova.cadastroveiculo.model.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository <Veiculos, Long> {

}
