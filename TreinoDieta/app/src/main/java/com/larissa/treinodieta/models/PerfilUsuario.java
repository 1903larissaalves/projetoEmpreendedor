package com.larissa.treinodieta.models;

import java.io.Serializable;

public class PerfilUsuario implements Serializable {

    private Long id;
    private String senha;
    private String data;
    private String email;
    private String tipousuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipousuario() {
        return tipousuario;
    }
    public String getSenha(){return senha;}
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

}
