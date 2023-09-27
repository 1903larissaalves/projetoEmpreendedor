package com.larissa.treinodieta.models;

import java.io.Serializable;

public class ExercicioDiario implements Serializable {

    private Long id;
    private String exercicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }
}
