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

        Bundle bundle = new Bundle();
        bundle.putString("message", "Tab " + position);

        exercicioSemanalFragment.setArguments(bundle);

        return exercicioSemanalFragment;
    }

    @Override
    public int getCount() {
        return 7; // 7 dias da semana
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String diaDaSemana;

        switch (position) {
            case 0:
                diaDaSemana = "Domingo";
                break;
            case 1:
                diaDaSemana = "Segunda-feira";
                break;
            case 2:
                diaDaSemana = "Terça-feira";
                break;
            case 3:
                diaDaSemana = "Quarta-feira";
                break;
            case 4:
                diaDaSemana = "Quinta-feira";
                break;
            case 5:
                diaDaSemana = "Sexta-feira";
                break;
            default:
                diaDaSemana = "Sábado";
        }
        return diaDaSemana;
    }
}
