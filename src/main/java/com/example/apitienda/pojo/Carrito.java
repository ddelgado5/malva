package com.example.apitienda.pojo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrito")
    private Long idCarrito;

    @Column(name = "descuento", precision = 15, scale = 2)
    private Double descuento;

    @Column(name = "total", precision = 15, scale = 2)
    private Double total;

    @Column(name = "subtotal", precision = 15, scale = 2)
    private Double subtotal;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<Item> items;

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
