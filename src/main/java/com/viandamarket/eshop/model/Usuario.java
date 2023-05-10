package com.viandamarket.eshop.model;
 

public class Usuario {
	private String domicilio;
	private String nombres;
	private String apellidos;
	private String correo;
	private String contrasenia;
	private Integer edad;
	private long id;
	private static long total=0;
	
	public Usuario(String domicilio, String nombres, String apellidos, String correo, String contrasenia,
			Integer edad) {
		super();
		this.domicilio = domicilio;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.edad = edad;
		Usuario.total++;
		this.id=Usuario.total;
	}
	
	public Usuario() {
		Usuario.total++;
		this.id=Usuario.total;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuarios [domicilio=" + domicilio + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo="
				+ correo + ", contrasenia=" + contrasenia + ", edad=" + edad + ", id=" + id + "]";
	}
	
	
	

}
