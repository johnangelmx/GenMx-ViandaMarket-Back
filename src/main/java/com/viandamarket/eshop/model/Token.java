package com.viandamarket.eshop.model;

public class Token {
    private final String acessToken;
    private Long idUsuario;

    public Token(String acessToken, Long idUsuario) {
        this.acessToken = acessToken;
        this.idUsuario = idUsuario;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Token{" +
                "acessToken='" + acessToken + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}// Class Token

