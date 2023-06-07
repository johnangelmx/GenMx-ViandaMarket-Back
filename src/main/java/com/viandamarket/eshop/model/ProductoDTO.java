package com.viandamarket.eshop.model;

public class ProductoDTO {
	 private int idProducto;
	    private String imagen;
	    private String nombre;
	    private double precio;
	    private int cantidad;

	    public int getIdProducto() {
	        return idProducto;
	    }

	    public void setIdProducto(int idProducto) {
	        this.idProducto = idProducto;
	    }

	    public String getImagen() {
	        return imagen;
	    }

	    public void setImagen(String imagen) {
	        this.imagen = imagen;
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

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(int cantidad) {
	        this.cantidad = cantidad;
	    }

}
