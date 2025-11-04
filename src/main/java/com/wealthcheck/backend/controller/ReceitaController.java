package com.wealthcheck.backend.controller;

import com.wealthcheck.backend.model.Receita;
import com.wealthcheck.backend.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    public ResponseEntity<Receita> criar(@RequestBody Receita receita) {
        Receita salva = receitaService.salvar(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Receita> listarTodas() {
        return receitaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Receita buscarPorId(@PathVariable Integer id) {
        return receitaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Receita atualizar(@PathVariable Integer id, @RequestBody Receita receita) {
        return receitaService.atualizar(id, receita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        receitaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
