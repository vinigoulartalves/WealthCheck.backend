package com.wealthcheck.backend.service;

import com.wealthcheck.backend.model.Receita;
import com.wealthcheck.backend.repository.ReceitaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public Receita buscarPorId(Integer id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receita não encontrada"));
    }

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }

    public Receita atualizar(Integer id, Receita receitaAtualizada) {
        Receita existente = buscarPorId(id);
        existente.setIdUsuario(receitaAtualizada.getIdUsuario());
        existente.setValor(receitaAtualizada.getValor());
        existente.setData(receitaAtualizada.getData());
        existente.setDescricao(receitaAtualizada.getDescricao());
        existente.setCategoria(receitaAtualizada.getCategoria());
        return receitaRepository.save(existente);
    }

    public void excluir(Integer id) {
        Receita existente = buscarPorId(id);
        receitaRepository.delete(existente);
    }
}
