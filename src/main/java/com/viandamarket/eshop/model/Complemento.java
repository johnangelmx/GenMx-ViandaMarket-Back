package com.viandamarket.eshop.model;

public class Complemento {
	private String nombre;
	private boolean disponibilidad;
	private int cantidad_disponible;
	private String descripcion_complemento;
	private double precio;
	private long id;
	private static long total=0;
//	public Complemento(String nombre, double d, String string, boolean b,
//			double precio) {
//		super();
//		this.nombre = nombre;
//		this.disponibilidad = d;
//		this.cantidad_disponible = string;
//		this.descripcion_complemento = b;
//		this.precio = precio;
//		Complemento.total++;
//		this.id=Complemento.total;
//	}
	public Complemento() {
		Complemento.total++;
		this.id=Complemento.total;
	}
	
	public Complemento(String nombre, boolean disponibilidad, int cantidad_disponible, 
			String descripcion_complemento,	double precio) {
	super();
	this.nombre = nombre;
	this.disponibilidad = disponibilidad;
	this.cantidad_disponible = cantidad_disponible;
	this.descripcion_complemento = descripcion_complemento;
	this.precio = precio;
	Complemento.total++;
	this.id=Complemento.total;
}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad_disponible() {
		return cantidad_disponible;
	}
	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}
	public String getDescripcion_complemento() {
		return descripcion_complemento;
	}
	public void setDescripcion_complemento(String descripcion_complemento) {
		this.descripcion_complemento = descripcion_complemento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getTotal() {
		return total;
	}
	public static void setTotal(long total) {
		Complemento.total = total;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}//setDisponibilidad
	@Override
	public String toString() {
		return "Complementos [nombre=" + nombre + ", disponibilidad=" + disponibilidad + ", cantidad_disponible="
				+ cantidad_disponible + ", descripcion_complemento=" + descripcion_complemento + ", precio=" + precio
				+ ", id=" + id + "]";
	}//toString	
}
