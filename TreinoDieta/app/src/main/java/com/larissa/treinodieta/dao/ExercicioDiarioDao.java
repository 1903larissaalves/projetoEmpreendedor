package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.ExercicioDiario;
import com.larissa.treinodieta.models.MedidasCorporal;

import java.util.ArrayList;
import java.util.List;

public class ExercicioDiarioDao extends SQLiteOpenHelper {

    static final int DB_VERSION = 1;

    public ExercicioDiarioDao( Context context) {
        super(context, "ExercicioDiario", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String banco = "CREATE TABLE IF NOT EXISTS ExercicioDiario(id INTEGER PRIMARY KEY," +
                " exercicio TEXT);";

        sqLiteDatabase.execSQL(banco);
    }

    public void inserirExercicioDiario() {
        SQLiteDatabase bancoSQL =  getWritableDatabase();

        ExercicioDiario exercicio = new ExercicioDiario();
        exercicio.setExercicio("Alongar Costas");
        ContentValues dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Alongar Pernas");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Alongar Pescoço");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Alongar Braços");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Rotações de Ombros");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Flexão de Quadril em pé");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Alongamento de Panturrilha");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Agachamento Profundo");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Estiramento de Peitoral");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);

        exercicio.setExercicio("Rotações de Tornozelo");
        dados = getInfoExercicioDiario(exercicio);
        bancoSQL.insert("ExercicioDiario", null, dados);
    }

    private ContentValues getInfoExercicioDiario(ExercicioDiario exercicioDiario) {

        ContentValues dados = new ContentValues();

        dados.put("exercicio", exercicioDiario.getExercicio());

        return dados;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<ExercicioDiario> buscarExerciciosDiario() {
        String banco = "SELECT * FROM ExercicioDiario;";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        List<ExercicioDiario> exerciciosDiario = new ArrayList<ExercicioDiario>();

        while (cursor.moveToNext()){
            ExercicioDiario exercicioDiario = new ExercicioDiario();

            exercicioDiario.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            exercicioDiario.setExercicio(cursor.getString(cursor.getColumnIndexOrThrow("exercicio")));

            exerciciosDiario.add(exercicioDiario);
        }
        cursor.close();

        return exerciciosDiario;
    }
}
