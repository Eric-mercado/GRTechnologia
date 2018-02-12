package com.erik.test.swaggerdemo.Bussines;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class ProductoBO {

        @Id
        @Column
        private String id;

        @Column
        private String nombre;

        @Column
        private double precio;

        @Column
        private Set<String> tags;
        private int puntosNuevos;
        private int precioPuntos;
        private String imageLocation;
        private String descripcion;

        public ProductoBO(String nombre, double precio, Set<String> tags, int puntosNuevos, int precioPuntos, String imageLocation, String descripcion) {
            this.nombre = nombre;
            this.precio = precio;
            this.tags = tags;
            this.puntosNuevos = puntosNuevos;
            this.precioPuntos = precioPuntos;
            this.imageLocation = imageLocation;
            this.descripcion = descripcion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public Set<String> getTags() {
            return tags;
        }

        public void setTags(Set<String> tags) {
            this.tags = tags;
        }

        public int getPuntosNuevos() {
            return puntosNuevos;
        }

        public void setPuntosNuevos(int puntosNuevos) {
            this.puntosNuevos = puntosNuevos;
        }

        public int getPrecioPuntos() {
            return precioPuntos;
        }

        public void setPrecioPuntos(int precioPuntos) {
            this.precioPuntos = precioPuntos;
        }

        public String getImageLocation() {
            return imageLocation;
        }

        public void setImageLocation(String imageLocation) {
            this.imageLocation = imageLocation;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void addTag(String newTag){
            this.tags.add(newTag);
        }
}
