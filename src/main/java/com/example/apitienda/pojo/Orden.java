package com.example.apitienda.pojo;

import jakarta.persistence.*;

@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordenId")
    private Long ordenId;

    @Column(name = "numero_orden", length = 45)
    private String numeroOrden;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente", unique = true)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "carrito_idCarrito", unique = true)
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "metEnvio_idMetEnvio")
    private MetodoPago metEnvio;

    @ManyToOne
    @JoinColumn(name = "metPago_idMet_pago")
    private MetodoEnvio metPago;

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public MetodoPago getMetEnvio() {
        return metEnvio;
    }

    public void setMetEnvio(MetodoPago metEnvio) {
        this.metEnvio = metEnvio;
    }

    public MetodoEnvio getMetPago() {
        return metPago;
    }

    public void setMetPago(MetodoEnvio metPago) {
        this.metPago = metPago;
    }
}
