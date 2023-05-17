package com.viandamarket.eshop.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "cortes")
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcortes", unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private double precio;
    private String descripcion_corte;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean disponibilidad;
    private float cantidad_disponible;
    private Integer idcalidades;


    public Corte(String nombre, double precio, String descripcion_corte, boolean disponibilidad, float cantidad_disponible, int idcalidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion_corte = descripcion_corte;
        this.disponibilidad = disponibilidad;
        this.cantidad_disponible = cantidad_disponible;
        this.idcalidades = idcalidades;
    }

    public Corte() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = Math.toIntExact(id);
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

    public String getDescripcion_corte() {
        return descripcion_corte;
    }

    public void setDescripcion_corte(String descripcion_corte) {
        this.descripcion_corte = descripcion_corte;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(float cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public long getIdcalidades() {
        return idcalidades;
    }

    public void setIdcalidades(long idcalidades) {
        this.idcalidades = Math.toIntExact(idcalidades);
    }

    @Override
    public String toString() {
        return "Corte{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", descripcion_corte='" + descripcion_corte + '\'' + ", disponibilidad=" + disponibilidad + ", cantidad_disponible=" + cantidad_disponible + ", idcalidades=" + idcalidades + '}';
    }


}
