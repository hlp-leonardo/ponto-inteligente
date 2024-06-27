package com.projeto.ponto_inteligente.api.repositories;

import entities.Lancamento;
import jakarta.persistence.NamedQuery;
import org.h2.mvstore.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", query = "SELECT lanc FROM lancamento WHERE lanc.funcionario.id = funcionarioId")

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
