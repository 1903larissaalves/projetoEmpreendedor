package com.larissa.treinodieta.models;

import java.io.Serializable;

public class CalcularIMC implements Serializable {

    private Long id;
    private String data;
    private String hora;
    private Float Resultado;
    private Float Peso;
    private Float Altura;

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Float getResultado() {
        return Resultado;
    }

    public Float getPeso(){
        return Peso;
    }

    public Float getAltura(){
        return Altura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPeso(Float Peso){
        this.Peso = Peso;
    }

    public void setAltura(Float Altura){
        this.Altura = Altura;
    }

    public void setResultado(Float resultado) {
        this.Resultado = resultado;
    }


    @Override
    public String toString() {
        String categoria;
        if (getResultado() < 18.5) {
            categoria = "Muito a baixo do normal";
        } else if (getResultado() < 24.9) {
            categoria = "Normal";
        } else if (getResultado() < 29.9) {
            categoria = "Sobrepeso";
        } else {
            categoria = "Obesidade";
        }

        return "Data: " + getData() + "\r   " +
                "           Hora: "+ getHora() + "\n" +
                "Peso: " + getPeso() + "Kg" + "\n" +
                "Valor IMC: " + String.format("%.2f", getResultado()) + "\n" +
                "IMC: " + categoria;
    }
}
