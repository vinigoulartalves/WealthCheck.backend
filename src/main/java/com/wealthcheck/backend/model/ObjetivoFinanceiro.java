package com.wealthcheck.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "objetivo_financeiro")
public class ObjetivoFinanceiro {

    @SequenceGenerator(
            name = "SEQ_OBJETIVO",
            sequenceName = "SEQ_OBJETIVO",
            allocationSize = 1)

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_OBJETIVO")

    @Column(name = "id_objetivo")
    private Integer idObjetivo;

    @Column(name = "usuario_id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "valor_meta", nullable = false)
    private double valorMeta; // se quiser precisão financeira, considere BigDecimal

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_prazo", nullable = false)
    private LocalDate dataPrazo;

    @Column(name = "status", length = 40, nullable = false)
    private String status;


    // Getters/Setters
    public Integer getIdObjetivo() { return idObjetivo; }
    public void setIdObjetivo(Integer idObjetivo) { this.idObjetivo = idObjetivo; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValorMeta() { return valorMeta; }
    public void setValorMeta(double valorMeta) { this.valorMeta = valorMeta; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataPrazo() { return dataPrazo; }
    public void setDataPrazo(LocalDate dataPrazo) { this.dataPrazo = dataPrazo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
