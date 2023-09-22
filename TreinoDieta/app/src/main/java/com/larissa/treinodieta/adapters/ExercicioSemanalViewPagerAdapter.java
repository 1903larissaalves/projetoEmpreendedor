package com.larissa.treinodieta.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.larissa.treinodieta.fragments.ExercicioSemanalFragment;

public class ExercicioSemanalViewPagerAdapter extends FragmentPagerAdapter {

    public ExercicioSemanalViewPagerAdapter(FragmentManager fm) {
        super(fm);
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
                exercicios[1] = "Barra W: 3 x 15" + "\r\n\n" +
                        "Rosca Scott: 3 x 15" + "\r\n\n" +
                        "Bíceps Corda: 3 x 15" + "\r\n\n" +
                        "Rosca Martelo: 3 x 15" + "\r\n\n";
                break;
            case 1:
                exercicios[0] = "Tríceps";
                exercicios[1] = "Testa: 3 x 15" + "\r\n\n" +
                        "Corda: 3 x 15" + "\r\n\n" +
                        "Banco: 3 x 15" + "\r\n\n" +
                        "Coice: 3 x 15" + "\r\n\n";
                break;
            case 2:
                exercicios[0] = "Perna";
                exercicios[1] = "Leg Press 45°: 3 x 15" + "\r\n\n" +
                        "Agachamento: 3 x 15" + "\r\n\n" +
                        "Flexor: 3 x 15" + "\r\n\n" +
                        "Extensor: 3 x 15" + "\r\n\n";
                break;
            case 3:
                exercicios[0] = "Costas";
                exercicios[1] = "Remada Aberta: 3 x 15" + "\r\n\n" +
                        "Remada Fechada: 3 x 15" + "\r\n\n" +
                        "Pulley: 3 x 15" + "\r\n\n" +
                        "Serrote: 3 x 15" + "\r\n\n";
                break;
            case 4:
                exercicios[0] = "Peito";
                exercicios[1] = "Supino Reto: 3 x 15" + "\r\n\n" +
                        "Supino Inclinado: 3 x 15" + "\r\n\n" +
                        "Supino Declinado: 3 x 15" + "\r\n\n" +
                        "Voador: 3 x 15" + "\r\n\n";
                break;
            case 5:
                exercicios[0] = "Ombro";
                exercicios[1] = "Elevação Lateral: 3 x 15" + "\r\n\n" +
                        "Elevação Frontal: 3 x 15" + "\r\n\n" +
                        "Encolhimento: 3 x 15" + "\r\n\n" +
                        "Desenvolvimento: 3 x 15" + "\r\n\n";
                break;
            default:
                exercicios[0] = "Abdômen e Lombar";
                exercicios[1] = "Abdominal infra: 3 x 15" + "\r\n\n" +
                        "Abdmonial Supra: 3 x 15" + "\r\n\n" +
                        "Prancha: 3 x 15" + "\r\n\n" +
                        "Lombar: 3 x 15" + "\r\n\n";
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
