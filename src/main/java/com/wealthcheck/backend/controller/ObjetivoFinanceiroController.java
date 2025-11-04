package com.wealthcheck.backend.controller;

import com.wealthcheck.backend.model.ObjetivoFinanceiro;
import com.wealthcheck.backend.service.ObjetivoFinanceiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetivos-financeiros")
public class ObjetivoFinanceiroController {

    private final ObjetivoFinanceiroService objetivoFinanceiroService;

    public ObjetivoFinanceiroController(ObjetivoFinanceiroService objetivoFinanceiroService) {
        this.objetivoFinanceiroService = objetivoFinanceiroService;
    }

    @PostMapping
    public ResponseEntity<ObjetivoFinanceiro> criar(@RequestBody ObjetivoFinanceiro objetivoFinanceiro) {
        ObjetivoFinanceiro salvo = objetivoFinanceiroService.salvar(objetivoFinanceiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<ObjetivoFinanceiro> listarTodos() {
        return objetivoFinanceiroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ObjetivoFinanceiro buscarPorId(@PathVariable Integer id) {
        return objetivoFinanceiroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ObjetivoFinanceiro atualizar(@PathVariable Integer id, @RequestBody ObjetivoFinanceiro objetivoFinanceiro) {
        return objetivoFinanceiroService.atualizar(id, objetivoFinanceiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        objetivoFinanceiroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
