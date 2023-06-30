package com.viandamarket.eshop.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //? Asigna al campo el valor autoincremental
    @Column(name = "idpedido", unique = true, nullable = false)
    private Long id_pedido;
    private String nombre;
    private int precio;
    private int cantidad;
    private boolean estatus = false;
    @CreationTimestamp
    @Column(name = "fecha_guardado")
    private LocalDateTime fechaGuardado;
    @Column(columnDefinition = "integer default 0")
    private Long id_usuarios;

    public Pedido(String nombre, int precio, int cantidad, boolean estatus, LocalDateTime fechaGuardado,
                  Long id_usuarios) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.fechaGuardado = fechaGuardado;
        this.id_usuarios = id_usuarios;
    }

    public Pedido() {
    }

    public Pedido(String nombre, int precio, int cantidad, int id_usuarios) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_usuarios = (long) id_usuarios;
    }

    public Long getId_pedido() {
        return id_pedido;
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

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public LocalDateTime getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(LocalDateTime fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public Long getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(Long id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedido [id_pedido=" + id_pedido + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
                + ", estatus=" + estatus + ", fechaGuardado=" + fechaGuardado + ", id_usuarios=" + id_usuarios + "]";
    }


}
