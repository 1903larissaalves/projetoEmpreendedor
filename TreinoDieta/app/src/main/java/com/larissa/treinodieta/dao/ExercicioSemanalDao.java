package com.larissa.treinodieta.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.ExercicioSemanal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ExercicioSemanalDao extends SQLiteOpenHelper {

    static final int DB_VERSION = 1;

    public ExercicioSemanalDao( Context context) {
        super(context, "ExercicioSemanal", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String banco = "CREATE TABLE IF NOT EXISTS ExercicioSemanal(id INTEGER PRIMARY KEY," +
                " tipoExercicio TEXT, " +
                " exercicio TEXT, " +
                " codigo INTEGER, " +
                " atual INTEGER);";

        sqLiteDatabase.execSQL(banco);

        inserirExercicioSemanal(sqLiteDatabase);
    }

    private void inserirExercicioSemanal(SQLiteDatabase sqLiteDatabase) {
        inserirExercicioBiceps(sqLiteDatabase);
        inserirExercicioTriceps(sqLiteDatabase);
        inserirExercicioPerna(sqLiteDatabase);
        inserirExercicioCostas(sqLiteDatabase);
        inserirExercicioPeito(sqLiteDatabase);
        inserirExercicioOmbro(sqLiteDatabase);
        inserirExercicioAbdomenLombar(sqLiteDatabase);
    }

    private void inserirExercicioBiceps(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Biceps";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Barra W: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rosca Scott: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Bíceps Corda: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rosca Martelo: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Barra Reta: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rosca Alternada: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rosca Concentrada: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioTriceps(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Triceps";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Triceps Testa: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Triceps Corda: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Banco: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Coice: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Supino Fechado: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Frances: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Barra Paralela: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioPerna(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Perna";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Leg Press: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Agachamento: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Flexor: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Extensor: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Adutor: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Abdutor: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Stiff: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioCostas(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Costas";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Remada Aberta: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Remada Fechada: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Pulley: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Serrote: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Levantamento Terra: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Crucifixo Inverso: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Barra Fixa: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioPeito(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Peito";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Supino Reto Barra: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Supino Inclinado: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Supino Declinado: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Voador: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Crossover Polia: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Supino Reto Halter: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Crucifixo: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioOmbro(SQLiteDatabase sqLiteDatabase) {
        String tipo = "Ombro";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Elevação Lateral: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Elevação Frontal: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Encolhimento: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Remada Alta: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rotação Externa: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Rotação Interna: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Arnold Press: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    private void inserirExercicioAbdomenLombar(SQLiteDatabase sqLiteDatabase) {
        String tipo = "AbdomenLombar";

        String insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Abdominal infra: 3 x 15\", 1, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Abdmonial Supra: 3 x 15\", 2, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Prancha: 3 x 15\", 3, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Elevação de Pernas: 3 x 15\", 4, 1);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Pancha Isométrica: 3 x 15\", 5, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Extensão de Tronco: 3 x 15\", 6, 0);";
        sqLiteDatabase.execSQL(insertExercicio);

        insertExercicio = "INSERT INTO ExercicioSemanal (tipoExercicio, exercicio, codigo, atual) " +
                "VALUES (" + '"' + tipo + '"' + ", \"Perdigueiro: 3 x 15\", 7, 0);";
        sqLiteDatabase.execSQL(insertExercicio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<ExercicioSemanal> buscarExercicioSemanal() {
        String banco = "SELECT * FROM ExercicioSemanal WHERE atual = 1;";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        ArrayList<ExercicioSemanal> exerciciosSemanal = new ArrayList<ExercicioSemanal>();

        while (cursor.moveToNext()) {
            ExercicioSemanal exercicio = new ExercicioSemanal();

            exercicio.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            exercicio.setTipoExercicio(cursor.getString(cursor.getColumnIndexOrThrow("tipoExercicio")));
            exercicio.setExercicio(cursor.getString(cursor.getColumnIndexOrThrow("exercicio")));
            exercicio.setCodigo(cursor.getInt(cursor.getColumnIndexOrThrow("codigo")));
            exercicio.setAtual(cursor.getInt(cursor.getColumnIndexOrThrow("atual")));

            exerciciosSemanal.add(exercicio);
        }
        cursor.close();

        return exerciciosSemanal;
    }

    public void randomizarExercicioAtual(List<ExercicioSemanal> exerciciosSemanal) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String updateExercicio = "UPDATE ExercicioSemanal SET atual = 0;";
        sqLiteDatabase.execSQL(updateExercicio);

        Integer[] codigos = new Integer[4];
        Boolean continuar = true;
        Integer posicaoLivre = 0;

        while(continuar) {
            Integer codigo = ThreadLocalRandom.current().nextInt(1, 7);


            Boolean jaExiste = false;

            for (int i = 0; i < codigos.length; i++) {
                if (codigos[i] == codigo) {
                    jaExiste = true;
                }
            }

            if (!jaExiste) {
                codigos[posicaoLivre] = codigo;
                posicaoLivre++;
            }

            if (posicaoLivre > 3) {
                continuar = false;
            }
        }

        updateExercicio = "UPDATE ExercicioSemanal SET atual = 1 WHERE codigo IN ("
                + codigos[0] + ", "
                + codigos[1] + " ,"
                + codigos[2] + " ,"
                + codigos[3] + ");";
        sqLiteDatabase.execSQL(updateExercicio);
    }
}
