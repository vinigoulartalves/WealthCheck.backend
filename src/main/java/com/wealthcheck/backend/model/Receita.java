package com.wealthcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "receita")
public class Receita extends TransacaoFinanceira {

    @SequenceGenerator(
            name = "SEQ_RECEITA",
            sequenceName = "SEQ_RECEITA",
            allocationSize = 1
    )

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_RECEITA")

    @Column(name = "id_receita")
    private Integer id;

    private String categoria;

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}