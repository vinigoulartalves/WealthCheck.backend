package com.wealthcheck.backend.repository;

import com.wealthcheck.backend.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
}
