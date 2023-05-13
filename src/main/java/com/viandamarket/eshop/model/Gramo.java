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
	private long idgramos;
	@Column(nullable = false)
	private double cantidad;
	@Column(columnDefinition = "integer default 0")
	private long cortes_idcortes;
	@Column(columnDefinition = "integer default 0")
	private long complementos_idcomplementos;
	

	public Gramo(long idgramos, double cantidad, long cortes_idcortes, long complementos_idcomplementos) {
		super();
		this.idgramos = idgramos;
		this.cantidad = cantidad;
		this.cortes_idcortes = cortes_idcortes;
		this.complementos_idcomplementos = complementos_idcomplementos;
	}
	
	public Gramo() {}


	public long getIdgramos() {
		return idgramos;
	}

	public void setIdgramos(long idgramos) {
		this.idgramos = idgramos;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public long getCortes_idcortes() {
		return cortes_idcortes;
	}

	public void setCortes_idcortes(long cortes_idcortes) {
		this.cortes_idcortes = cortes_idcortes;
	}

	public long getComplementos_idcomplementos() {
		return complementos_idcomplementos;
	}

	public void setComplementos_idcomplementos(long complementos_idcomplementos) {
		this.complementos_idcomplementos = complementos_idcomplementos;
	}

	@Override
	public String toString() {
		return "Gramo [idgramos=" + idgramos + ", cantidad=" + cantidad + ", cortes_idcortes=" + cortes_idcortes
				+ ", complementos_idcomplementos=" + complementos_idcomplementos + "]";
	}

		

}//class Gramo
