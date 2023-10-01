package com.larissa.treinodieta.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.ExercicioDiario;

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

        inserirExercicioDiario(sqLiteDatabase);
    }

    public void inserirExercicioDiario(SQLiteDatabase sqLiteDatabase) {
        String insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Alongar Costas" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Alongar Pernas" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Alongar Pescoço" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Alongar Braços" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Rotações de Ombros" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Flexão de Quadril em pé" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Alongamento de Panturrilha" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Agachamento Profundo" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Estiramento de Peitoral" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioDiario (exercicio) VALUES (" + '"' + "Rotações de Tornozelo" + '"' + ");";
        sqLiteDatabase.execSQL(insertExercicio);
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
