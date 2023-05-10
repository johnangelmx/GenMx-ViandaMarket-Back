package com.viandamarket.eshop.model;

public class Calidad {
	private String marca;
	private String pais;
	private String descripcion_marca;
	private String calidad;
	private long id;
	private static long total=0;
	
	public Calidad(String marca, String pais, String descripcion_marca, String calidad) {
		super();
		this.marca = marca;
		this.pais = pais;
		this.descripcion_marca = descripcion_marca;
		this.calidad = calidad;
		
		Calidad.total++;
		this.id=Calidad.total;
	}

	public Calidad() {		
		Calidad.total++;
		this.id=Calidad.total;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDescripcion_marca() {
		return descripcion_marca;
	}

	public void setDescripcion_marca(String descripcion_marca) {
		this.descripcion_marca = descripcion_marca;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Calidades [marca=" + marca + ", pais=" + pais + ", descripcion_marca=" + descripcion_marca
				+ ", calidad=" + calidad + "]";
	}

	
}
