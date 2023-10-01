package com.larissa.treinodieta.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.larissa.treinodieta.fragments.ExercicioSemanalFragment;
import com.larissa.treinodieta.models.ExercicioSemanal;

import java.util.List;
import java.util.Locale;

public class ExercicioSemanalViewPagerAdapter extends FragmentPagerAdapter {

    private List<ExercicioSemanal> exerciciosSemanal;

    public ExercicioSemanalViewPagerAdapter(FragmentManager fm, List<ExercicioSemanal> exerciciosSemanal) {
        super(fm);
        this.exerciciosSemanal = exerciciosSemanal;
    }

    @Override
    public Fragment getItem(int position) {
        ExercicioSemanalFragment exercicioSemanalFragment = new ExercicioSemanalFragment();

        String[] listaDeExercicios = getExercicios(position);

        Bundle bundle = new Bundle();
        bundle.putString("tipoExercicio", listaDeExercicios[0]);
        bundle.putString("listaExercicios", listaDeExercicios[1]);

        exercicioSemanalFragment.setArguments(bundle);

        return exercicioSemanalFragment;
    }

    private String[] getExercicios(int diaDaSemana) {
        String[] exercicios = new String[2];

        switch (diaDaSemana) {
            case 0:
                exercicios[0] = "Bíceps";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("biceps")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }

                break;
            case 1:
                exercicios[0] = "Tríceps";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("triceps")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
            case 2:
                exercicios[0] = "Perna";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("perna")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
            case 3:
                exercicios[0] = "Costas";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("costas")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
            case 4:
                exercicios[0] = "Peito";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("peito")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
            case 5:
                exercicios[0] = "Ombro";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("ombro")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
            default:
                exercicios[0] = "Abdômen e Lombar";
                exercicios[1] = "";

                for (ExercicioSemanal exercicio : exerciciosSemanal) {
                    if (exercicio.getTipoExercicio().toLowerCase(Locale.ROOT).equals("abdomenlombar")) {
                        exercicios[1] += exercicio.getExercicio() + "\r\n\n";
                    }
                }
                break;
        }

        return  exercicios;
    }

    @Override
    public int getCount() {

        return 7; // 7 dias da semana
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Domingo";
            case 1:
                return "Segunda-feira";
            case 2:
                return "Terça-feira";
            case 3:
                return "Quarta-feira";
            case 4:
                return "Quinta-feira";
            case 5:
                return "Sexta-feira";
            default:
                return "Sábado";
        }
    }
}
