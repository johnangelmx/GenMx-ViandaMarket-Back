package com.viandamarket.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

///POJO - Plain Old Java Object


@Entity
@Table(name="calidades")
public class Calidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcalidades", unique = true, nullable = false)
	private long id;
	private String marca;
	private String pais;
	private String descripcion_marca;
	@Column (nullable = false)
	private String calidad;
	
	
	public Calidad(String marca, String pais, String descripcion_marca, String calidad) {
		super();
		this.marca = marca;
		this.pais = pais;
		this.descripcion_marca = descripcion_marca;
		this.calidad = calidad;
		
		
	}//Constructor

	public Calidad() {}//constructor default

	public String getMarca() {
		return marca;
	}//getMarca

	public void setMarca(String marca) {
		this.marca = marca;
	}//setMarca

	public String getPais() {
		return pais;
	}//getPais

	public void setPais(String pais) {
		this.pais = pais;
	}//setPais

	public String getDescripcion_marca() {
		return descripcion_marca;
	}//getDescripcion_marca

	public void setDescripcion_marca(String descripcion_marca) {
		this.descripcion_marca = descripcion_marca;
	}//setDescripcion_marca

	public String getCalidad() {
		return calidad;
	}//getCalidad

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}//setCalidad

	public long getId() {
		return id;
	}//getId

	public void setId(long id) {
		this.id = id;
	}//setId

	@Override
	public String toString() {
		return "Calidades [marca=" + marca + ", pais=" + pais + ", descripcion_marca=" + descripcion_marca
				+ ", calidad=" + calidad + "]";
	}//toString

	
}//class
