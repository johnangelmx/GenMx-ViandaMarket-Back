package com.viandamarket.eshop.model;

public class ChangePassword {
    private String contrasena;
    private String newContrasena;

    public ChangePassword(String contrasena, String newContrasena) {
        this.contrasena = contrasena;
        this.newContrasena = newContrasena;
    }

    public ChangePassword() {
    }

    //? Setter & Getter ⬇

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNewContrasena() {
        return newContrasena;
    }

    public void setNewContrasena(String newContrasena) {
        this.newContrasena = newContrasena;
    }


    //? Setter & Getter ⬆ ️
    //? ToString

    @Override
    public String toString() {
        return "ChangePassword{" + "contrasena='" + contrasena + '\'' + ", newContrasena='" + newContrasena + '\'' + '}';
    }
}
