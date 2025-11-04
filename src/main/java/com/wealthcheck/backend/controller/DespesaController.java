package com.wealthcheck.backend.controller;

import com.wealthcheck.backend.model.Despesa;
import com.wealthcheck.backend.service.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping
    public ResponseEntity<Despesa> criar(@RequestBody Despesa despesa) {
        Despesa salva = despesaService.salvar(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Despesa> listarTodas() {
        return despesaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Despesa buscarPorId(@PathVariable Integer id) {
        return despesaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Despesa atualizar(@PathVariable Integer id, @RequestBody Despesa despesa) {
        return despesaService.atualizar(id, despesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        despesaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
