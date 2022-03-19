package com.udemy.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
