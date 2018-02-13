package com.erik.test.swaggerdemo.Bussines;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class ProductoBO {

        @Id
        private String id;


        private String nombre;

    @Override
    public String toString() {
        return "ProductoBO{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tags=" + tags +
                ", puntosNuevos=" + puntosNuevos +
                ", precioPuntos=" + precioPuntos +
                ", imageLocation='" + imageLocation + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


        private double precio;


        private Set<String> tags;

        private int puntosNuevos;

        private int precioPuntos;


        private String imageLocation;


        private String descripcion;

        public ProductoBO(String id, String nombre, double precio, Set<String> tags, int puntosNuevos, int precioPuntos, String imageLocation, String descripcion) {

            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.tags = tags;
            this.puntosNuevos = puntosNuevos;
            this.precioPuntos = precioPuntos;
            this.imageLocation = imageLocation;
            this.descripcion = descripcion;
        }

        protected ProductoBO(){

        }

        public String getId(){
            return id;
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
