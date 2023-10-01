package com.larissa.treinodieta.models;

import java.io.Serializable;

public class ExercicioSemanal implements Serializable {

    private Long id;
    private String tipoExercicio;
    private String exercicio;
    private Integer codigo;
    private Integer atual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoExercicio() { return tipoExercicio; }

    public void setTipoExercicio(String tipoExercicio) { this.tipoExercicio = tipoExercicio; }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAtual() {
        return atual;
    }

    public void setAtual(Integer atual) {
        this.atual = atual;
    }
}
