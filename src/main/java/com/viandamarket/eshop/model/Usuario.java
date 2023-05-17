package com.viandamarket.eshop.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //? Asigna al campo el valor autoincremental
    @Column(name = "idUsuarios", unique = true, nullable = false)
    private Integer id;

    private String domicilio;

    private String nombres;

    private String apellidos;

    private String correo;

    private String contrasena;

    private Integer edad;


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

    public long getId() {
        return id;
    }

    public void setId(Long idUsuarios) {
        this.id = Math.toIntExact(idUsuarios);
    }
    //? Setter & Getter ⬆ ️

    //? To String ⬇

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", domicilio='" + domicilio + '\'' + ", nombres='" + nombres + '\'' + ", apellidos='" + apellidos + '\'' + ", correo='" + correo + '\'' + ", contrasena='" + contrasena + '\'' + ", edad=" + edad + '}';
    }
}
