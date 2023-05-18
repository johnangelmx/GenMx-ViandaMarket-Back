package com.viandamarket.eshop.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //? Asigna al campo el valor autoincremental
    @Column(name = "id_usuarios", unique = true, nullable = false)
    private Long id;

    private String domicilio = "Desconocido";

    private String nombres = "John";

    private String apellidos = "Doe";

    private String correo;

    private String contrasena;

    private Integer edad = 18;

    //? Contructors ⬇

    public Usuario(String domicilio, String nombres, String apellidos, String correo, String contrasena, Integer edad) {
        this.domicilio = domicilio;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.edad = edad;
    }

    public Usuario() {
    }
    //? Setter & Getter ⬇


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //? Setter & Getter ⬆ ️

    //? To String ⬇

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", domicilio='" + domicilio + '\'' + ", nombres='" + nombres + '\'' + ", apellidos='" + apellidos + '\'' + ", correo='" + correo + '\'' + ", contrasena='" + contrasena + '\'' + ", edad=" + edad + '}';
    }
}
