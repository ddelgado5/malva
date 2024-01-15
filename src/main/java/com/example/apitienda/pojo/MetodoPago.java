package com.example.apitienda.pojo;

import jakarta.persistence.*;

@Entity
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodoPago")
    private Long idMetodoPago;

    @Column(name = "nombre", length = 45)
    private String nombre;

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
