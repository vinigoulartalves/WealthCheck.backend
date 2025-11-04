package com.wealthcheck.backend.service;

import com.wealthcheck.backend.model.Investimento;
import com.wealthcheck.backend.repository.InvestimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository) {
        this.investimentoRepository = investimentoRepository;
    }

    public Investimento salvar(Investimento investimento) {
        return investimentoRepository.save(investimento);
    }

    public Investimento buscarPorId(Integer id) {
        return investimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Investimento não encontrado"));
    }

    public List<Investimento> listarTodos() {
        return investimentoRepository.findAll();
    }

    public Investimento atualizar(Integer id, Investimento investimentoAtualizado) {
        Investimento existente = buscarPorId(id);
        existente.setIdUsuario(investimentoAtualizado.getIdUsuario());
        existente.setValor(investimentoAtualizado.getValor());
        existente.setData(investimentoAtualizado.getData());
        existente.setDescricao(investimentoAtualizado.getDescricao());
        existente.setTipoInvestimento(investimentoAtualizado.getTipoInvestimento());
        return investimentoRepository.save(existente);
    }

    public void excluir(Integer id) {
        Investimento existente = buscarPorId(id);
        investimentoRepository.delete(existente);
    }
}
