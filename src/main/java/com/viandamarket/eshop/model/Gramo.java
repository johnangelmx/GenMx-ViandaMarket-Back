package com.viandamarket.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gramos")
public class Gramo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idgramos;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(columnDefinition = "integer default 0")
    private Long idcortes;
    @Column(columnDefinition = "integer default 0")
    private Long idcomplementos;


    //? Constructores ⬇


    public Gramo(Integer cantidad, Long idcortes, Long idcomplementos) {
        this.cantidad = cantidad;
        this.idcortes = idcortes;
        this.idcomplementos = idcomplementos;
    }

    public Gramo() {
    }
    //? Getters & Setters ⬇

    public Long getIdgramos() {
        return idgramos;
    }

    public void setIdgramos(Long idgramos) {
        this.idgramos = idgramos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdcortes() {
        return idcortes;
    }

    public void setIdcortes(Long idcortes) {
        this.idcortes = idcortes;
    }

    public Long getIdcomplementos() {
        return idcomplementos;
    }

    public void setIdcomplementos(Long idcomplementos) {
        this.idcomplementos = idcomplementos;
    }

    //? Getters & Setters ⬆

    //? ToString()⬇

    @Override
    public String toString() {
        return "Gramo{" + "idgramos=" + idgramos + ", cantidad=" + cantidad + ", idcortes=" + idcortes + ", idcomplementos=" + idcomplementos + '}';
    }
}//class Gramo
