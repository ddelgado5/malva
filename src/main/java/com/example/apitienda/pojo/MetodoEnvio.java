package com.example.apitienda.pojo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class MetodoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodoEnvio")
    private Long idMetodoEnvio;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "valor", precision = 15, scale = 2)
    private BigDecimal valor;

    public Long getIdMetodoEnvio() {
        return idMetodoEnvio;
    }

    public void setIdMetodoEnvio(Long idMetodoEnvio) {
        this.idMetodoEnvio = idMetodoEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
