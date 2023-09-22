package com.larissa.treinodieta.adapters;

import android.os.Bundle;
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
        position++;

        String diaDaSemana;

        switch (position) {
            case 1:
                diaDaSemana = "Domingo";
                break;
            case 2:
                diaDaSemana = "Segunda-feira";
                break;
            case 3:
                diaDaSemana = "Terça-feira";
                break;
            case 4:
                diaDaSemana = "Quarta-feira";
                break;
            case 5:
                diaDaSemana = "Quinta-feira";
                break;
            case 6:
                diaDaSemana = "Sexta-feira";
                break;
            default:
                diaDaSemana = "Sábado";
        }

        Bundle bundle = new Bundle();
        bundle.putString("message", diaDaSemana);

        exercicioSemanalFragment.setArguments(bundle);

        return exercicioSemanalFragment;
    }

    @Override
    public int getCount() {
        return 7; // 7 dias da semana
    }
}
