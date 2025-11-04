package com.wealthcheck.backend.repository;

import com.wealthcheck.backend.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
