package com.erik.test.swaggerdemo.Bussines;


import org.springframework.data.annotation.Id;

import java.util.Set;

public class PromoBO {

    @Id
    private String id;
    private Set<ProductoBO> productos;
    private int precio;
    private String promoName;
    private Set<String>tags;
    private String descripcion;
    private int puntos;
    private int precioPuntos;

    public PromoBO(String id, Set<ProductoBO> productos, int precio, Set<String> tags, String descripcion, int puntos, int precioPuntos, String promoName) {
        this.id = id;
        this.productos = productos;
        this.precio = precio;
        this.tags = tags;
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.precioPuntos = precioPuntos;
        this.promoName = promoName;
    }


    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }
    public Set<ProductoBO> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoBO> productos) {
        this.productos = productos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPrecioPuntos() {
        return precioPuntos;
    }

    public void setPrecioPuntos(int precioPuntos) {
        this.precioPuntos = precioPuntos;
    }
}
