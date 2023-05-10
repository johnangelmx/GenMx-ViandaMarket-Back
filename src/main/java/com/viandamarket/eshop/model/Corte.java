package com.viandamarket.eshop.model;
 
public class Corte {
	private String nombre;
	private double precio;
	private String descripcion_corte;
	private boolean disponibilidad;
	private float cantidad_disponible; 
	private long idcalidades;
	private long id;
	private static long total=0;
	
	public Corte(String nombre, double precio, String descripcion_corte, boolean disponibilidad,
			float cantidad_disponible, long idcalidades) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion_corte = descripcion_corte;
		this.disponibilidad = disponibilidad;
		this.cantidad_disponible = cantidad_disponible;
		this.idcalidades = idcalidades;
		
		Corte.total++;
		this.id=Corte.total;
	}
	public Corte() { 
		Corte.total++;
		this.id=Corte.total;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String corte) {
		this.nombre = corte;
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
		this.idcalidades = idcalidades;
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
		Corte.total = total;
	}
	@Override
	public String toString() {
		return "Cortes [nombre=" + nombre + ", precio=" + precio + ", descripcion_corte=" + descripcion_corte
				+ ", disponibilidad=" + disponibilidad + ", cantidad_disponible=" + cantidad_disponible
				+ ", idcalidades=" + idcalidades + ", id=" + id + "]";
	}
	
	
	
	
}
