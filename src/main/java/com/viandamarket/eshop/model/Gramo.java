package com.viandamarket.eshop.model;

public class Gramo {
	private Integer gramos;
	private long idcortes;
	private long idcomplementos;
	private long id;
	private static long total=0;
	public Gramo(Integer gramos, long idcortes, long idcomplementos) {
		super();
		this.gramos = gramos;
		this.idcortes = idcortes;
		this.idcomplementos = idcomplementos;
		
		Gramo.total++;
		this.id=Gramo.total;
	}
	public Gramo() {
		
		Gramo.total++;
		this.id=Gramo.total;
	}
	public Integer getGramos() {
		return gramos;
	}
	public void setGramos(Integer gramos) {
		this.gramos = gramos;
	}
	public long getIdcortes() {
		return idcortes;
	}
	public void setIdcortes(long idcortes) {
		this.idcortes = idcortes;
	}
	public long getIdcomplementos() {
		return idcomplementos;
	}
	public void setIdcomplementos(long idcomplementos) {
		this.idcomplementos = idcomplementos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Gramos [gramos=" + gramos + ", idcortes=" + idcortes + ", idcomplementos=" + idcomplementos + ", id="
				+ id + "]";
	}
	
	
	
}
