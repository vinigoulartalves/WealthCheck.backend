package com.wealthcheck.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "despesa")
public class Despesa extends TransacaoFinanceira {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "SEQ_DESPESA")

    @SequenceGenerator(
            name = "SEQ_DESPESA",
            sequenceName = "SEQ_DESPESA",
            allocationSize = 1
    )

    @Column(name = "id_despesa")
    private Integer id;

    @Column(length = 60)
    private String categoria;

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}