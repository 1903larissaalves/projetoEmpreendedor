package com.larissa.treinodieta.models;

import java.io.Serializable;

public class ControleSono implements Serializable {

    private Long id;
    private String data;
    private Float tempoDisponiveisSono;

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

    public Float getTempoDisponiveisSono() {
        return tempoDisponiveisSono;
    }

    public void setTempoDisponiveisSono(Float tempoDisponiveisSono) {
        this.tempoDisponiveisSono = tempoDisponiveisSono;
    }
}
