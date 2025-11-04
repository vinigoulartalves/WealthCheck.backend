package com.wealthcheck.backend.repository;

import com.wealthcheck.backend.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {
}
