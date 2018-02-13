package com.erik.test.swaggerdemo.builder;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;

import java.util.Set;

public class ProductoBuilder {
    private String id;
    private String nombre;
    private double precio;
    private Set<String> tags;
    private int puntosNuevos;
    private int precioPuntos;
    private String imageLocation;
    private String descripcion;


    public ProductoBuilder setiD(String id){
        this.id = id;
        return this;
    }
    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProductoBuilder setPuntosNuevos(int puntosNuevos) {
        this.puntosNuevos = puntosNuevos;
        return this;
    }

    public ProductoBuilder setPrecioPuntos(int precioPuntos) {
        this.precioPuntos = precioPuntos;
        return this;
    }

    public ProductoBuilder setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
        return this;
    }

    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoBO build(){

        return new ProductoBO(
                this.id,
                this.nombre,
                this.precio,
                this.tags,
                this.puntosNuevos,
                this.precioPuntos,
                this.imageLocation,
                this.descripcion);
    }
}
