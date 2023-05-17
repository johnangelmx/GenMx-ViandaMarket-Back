package com.viandamarket.eshop.model;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="complementos")
public class Complemento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcomplementos",unique=true,nullable=false)
	private Integer id;
	@Column(nullable=false)
	private String nombre;
	@Column(columnDefinition = "TINYINT",nullable=false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean disponibilidad;
	@Column(nullable=false)
	private Double cantidad_disponible;
	@Column(nullable=false)
	private String descripcion_complemento;
	@Column(nullable=false)
	private float precio;
	
	public Complemento() {
	}

	public Complemento(String nombre, boolean disponibilidad, Double cantidad_disponible,
			String descripcion_complemento, float precio) {
		this.nombre = nombre;
		this.disponibilidad = disponibilidad;
		this.cantidad_disponible = cantidad_disponible;
		this.descripcion_complemento = descripcion_complemento;
		this.precio = precio;
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

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Double getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = (double) cantidad_disponible;
	}

	public String getDescripcion_complemento() {
		return descripcion_complemento;
	}

	public void setDescripcion_complemento(String descripcion_complemento) {
		this.descripcion_complemento = descripcion_complemento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Complemento [id=" + id + ", nombre=" + nombre + ", disponibilidad=" + disponibilidad
				+ ", cantidad_disponible=" + cantidad_disponible + ", descripcion_complemento="
				+ descripcion_complemento + ", precio=" + precio + "]";
	}
	
	
	
	
}
