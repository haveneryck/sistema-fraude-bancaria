package com.haveneryck.sistemafraudebancaria.repository;

import com.haveneryck.sistemafraudebancaria.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}