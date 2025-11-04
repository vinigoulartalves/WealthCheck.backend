package com.wealthcheck.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "investimento")
public class Investimento extends TransacaoFinanceira {

    @SequenceGenerator(
            name = "SEQ_INVESTIMENTO",
            sequenceName = "SEQ_INVESTIMENTO",
            allocationSize = 1)

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_INVESTIMENTO")

    @Column(name = "id_investimento")
    private Integer id;

    @Column(name = "tipo_investimento")
    private String tipoInvestimento;

    // Getters/Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; } // geralmente não usado com IDENTITY

    public String getTipoInvestimento() { return tipoInvestimento; }
    public void setTipoInvestimento(String tipoInvestimento) { this.tipoInvestimento = tipoInvestimento; }
}
