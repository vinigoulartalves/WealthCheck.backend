package com.wealthcheck.backend.service;

import com.wealthcheck.backend.model.Despesa;
import com.wealthcheck.backend.repository.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa salvar(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public Despesa buscarPorId(Integer id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Despesa não encontrada"));
    }

    public List<Despesa> listarTodas() {
        return despesaRepository.findAll();
    }

    public Despesa atualizar(Integer id, Despesa despesaAtualizada) {
        Despesa existente = buscarPorId(id);
        existente.setIdUsuario(despesaAtualizada.getIdUsuario());
        existente.setValor(despesaAtualizada.getValor());
        existente.setData(despesaAtualizada.getData());
        existente.setDescricao(despesaAtualizada.getDescricao());
        existente.setCategoria(despesaAtualizada.getCategoria());
        return despesaRepository.save(existente);
    }

    public void excluir(Integer id) {
        Despesa existente = buscarPorId(id);
        despesaRepository.delete(existente);
    }
}
