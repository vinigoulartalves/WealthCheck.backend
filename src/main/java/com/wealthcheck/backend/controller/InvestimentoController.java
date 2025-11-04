package com.wealthcheck.backend.controller;

import com.wealthcheck.backend.model.Investimento;
import com.wealthcheck.backend.service.InvestimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @PostMapping
    public ResponseEntity<Investimento> criar(@RequestBody Investimento investimento) {
        Investimento salvo = investimentoService.salvar(investimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Investimento> listarTodos() {
        return investimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Investimento buscarPorId(@PathVariable Integer id) {
        return investimentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Investimento atualizar(@PathVariable Integer id, @RequestBody Investimento investimento) {
        return investimentoService.atualizar(id, investimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        investimentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
