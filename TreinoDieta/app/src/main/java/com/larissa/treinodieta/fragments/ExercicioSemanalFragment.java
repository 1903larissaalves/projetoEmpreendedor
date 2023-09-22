package com.larissa.treinodieta.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.larissa.treinodieta.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExercicioSemanalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExercicioSemanalFragment extends Fragment {

    private TextView textViewTipo;
    private TextView textViewLista;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExercicioSemanalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExercicioSemanalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExercicioSemanalFragment newInstance(String param1, String param2) {
        ExercicioSemanalFragment fragment = new ExercicioSemanalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercicio_semanal, container, false);

        String tipoExercicio = getArguments().getString("tipoExercicio").toUpperCase();
        String listaExercicios = getArguments().getString("listaExercicios");

        textViewTipo = view.findViewById(R.id.txt_tipoExercicio);
        textViewTipo.setText(tipoExercicio);

        textViewLista = view.findViewById(R.id.txt_listaExercicios);
        textViewLista.setText(listaExercicios);

        return  view;
    }
}