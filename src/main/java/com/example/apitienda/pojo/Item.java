package com.example.apitienda.pojo;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditems")
    private Long idItems;

    @Column(name = "precio_venta", precision = 15, scale = 2)
    private Double precioVenta;

    @Column(name = "precio_original", precision = 15, scale = 2)
    private Double precioOriginal;

    @Column(name = "cant")
    private Integer cantidad;

    @Column(name = "descuento", precision = 15, scale = 2)
    private Double descuento;

    @OneToOne
    @JoinColumn(name = "Producto_idProducto", unique = true)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "Carrito_idCarrito", unique = true)
    private Carrito carrito;

    public Long getIdItems() {
        return idItems;
    }

    public void setIdItems(Long idItems) {
        this.idItems = idItems;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Double precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}