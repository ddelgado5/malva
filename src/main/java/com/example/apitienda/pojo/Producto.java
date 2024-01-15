package com.example.apitienda.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


//@NamedQueries(name="",query="")
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProducto;

    @Column(name ="nombre")
    private String nombre;
    @Column(name ="sku")
    private String sku;
    @Column(name ="precio")
    private double precio;
    @Column(name ="compare_precio")
    private double comparePrecio;
    @Column(name ="cant")
    private int cant;
    @Column(name ="imagen")
    private String imagen;

    public Producto() {
        super();
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.comparePrecio = comparePrecio;
        this.cant = cant;
        this.imagen = imagen;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getComparePrecio() {
        return comparePrecio;
    }

    public void setComparePrecio(double comparePrecio) {
        this.comparePrecio = comparePrecio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
