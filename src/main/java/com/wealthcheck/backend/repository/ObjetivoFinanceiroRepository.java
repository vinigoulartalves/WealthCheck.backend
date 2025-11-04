package com.wealthcheck.backend.repository;

import com.wealthcheck.backend.model.ObjetivoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoFinanceiroRepository extends JpaRepository<ObjetivoFinanceiro, Integer> {
}
