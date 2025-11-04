package com.wealthcheck.backend.service;

import com.wealthcheck.backend.model.ObjetivoFinanceiro;
import com.wealthcheck.backend.repository.ObjetivoFinanceiroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoFinanceiroService {

    private final ObjetivoFinanceiroRepository objetivoFinanceiroRepository;

    public ObjetivoFinanceiroService(ObjetivoFinanceiroRepository objetivoFinanceiroRepository) {
        this.objetivoFinanceiroRepository = objetivoFinanceiroRepository;
    }

    public ObjetivoFinanceiro salvar(ObjetivoFinanceiro objetivoFinanceiro) {
        return objetivoFinanceiroRepository.save(objetivoFinanceiro);
    }

    public ObjetivoFinanceiro buscarPorId(Integer id) {
        return objetivoFinanceiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Objetivo financeiro não encontrado"));
    }

    public List<ObjetivoFinanceiro> listarTodos() {
        return objetivoFinanceiroRepository.findAll();
    }

    public ObjetivoFinanceiro atualizar(Integer id, ObjetivoFinanceiro objetivoFinanceiroAtualizado) {
        ObjetivoFinanceiro existente = buscarPorId(id);
        existente.setIdUsuario(objetivoFinanceiroAtualizado.getIdUsuario());
        existente.setDescricao(objetivoFinanceiroAtualizado.getDescricao());
        existente.setValorMeta(objetivoFinanceiroAtualizado.getValorMeta());
        existente.setDataInicio(objetivoFinanceiroAtualizado.getDataInicio());
        existente.setDataPrazo(objetivoFinanceiroAtualizado.getDataPrazo());
        existente.setStatus(objetivoFinanceiroAtualizado.getStatus());
        return objetivoFinanceiroRepository.save(existente);
    }

    public void excluir(Integer id) {
        ObjetivoFinanceiro existente = buscarPorId(id);
        objetivoFinanceiroRepository.delete(existente);
    }
}
