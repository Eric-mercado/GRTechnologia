package com.erik.test.swaggerdemo.builder;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.Bussines.PromoBO;

import java.util.Set;

public class PromoBuilder {

        private Set<ProductoBO> productos;
        private int precio;
        private Set<String> tags;
        private String descripcion;
        private int puntos;
        private int precioPuntos;

        public PromoBuilder setPromoName(String promoName) {
            this.promoName = promoName;
            return this;
        }

        private String promoName;

        public PromoBuilder setProductos(Set<ProductoBO> productos) {
            this.productos = productos;
            return this;
        }

        public PromoBuilder setPrecio(int precio) {
            this.precio = precio;
            return this;
        }

        public PromoBuilder setTags(Set<String> tags) {
            this.tags = tags;
            return this;
        }

        public PromoBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public PromoBuilder setPuntos(int puntos) {
            this.puntos = puntos;
            return this;
        }

        public PromoBuilder setPrecioPuntos(int precioPuntos) {
            this.precioPuntos = precioPuntos;
            return this;
        }

        public PromoBO build(){
            return new PromoBO(this.productos,
                    this.precio,
                    this.tags,
                    this.descripcion,
                    this.puntos,
                    this.precioPuntos,
                    this.promoName);
        }

}
