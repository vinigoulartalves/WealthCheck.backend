package com.wealthcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "receita")
public class Receita extends TransacaoFinanceira {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "SEQ_RECEITA")

    @SequenceGenerator(
            name = "SEQ_RECEITA",
            sequenceName = "SEQ_RECEITA",
            allocationSize = 1
    )

    @Column(name = "id_receita")
    private Integer id;

    private String categoria;

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}