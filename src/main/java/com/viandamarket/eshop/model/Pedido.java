package com.viandamarket.eshop.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido",unique = true, nullable = false)
 	private long id_pedido;    
    private String nombre;    
    private int precio;    
    private int cantidad;
    @Column(columnDefinition = "integer default 0")
    private Long id_usuarios; 

    
    public Pedido(long id_pedido, String nombre, int precio, int cantidad, Long id_usuarios) { 
		this.id_pedido = id_pedido;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.id_usuarios = id_usuarios;
	}
    
	public Pedido() { 
		
	}



	public long getid_pedido() {
        return id_pedido;
    }

    public void setid_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
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
		return "Pedido [id_pedido=" + id_pedido + ", nombre=" + nombre + ", precio=" + precio + ", cantidad="
				+ cantidad + ", id_usuarios=" + id_usuarios + "]";
	}

    
    
}