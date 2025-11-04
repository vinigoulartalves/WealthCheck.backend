package com.wealthcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "receita")
public class Receita extends TransacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_receita")
    private Integer id;

    private String categoria;

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}