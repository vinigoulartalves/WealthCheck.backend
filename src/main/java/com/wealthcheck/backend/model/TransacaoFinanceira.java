package com.wealthcheck.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class TransacaoFinanceira {

    @Column(name = "id_usuario")

    private Integer idUsuario;
    private double valor;
    private LocalDate data;
    private String descricao;

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
