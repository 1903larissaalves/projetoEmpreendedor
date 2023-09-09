package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.larissa.treinodieta.models.CalcularIMC;

import java.util.ArrayList;
import java.util.List;

public class imcDAO<IMC> extends SQLiteOpenHelper {

    public imcDAO(Context context) {
        super(context, "IMC", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String banco = "CREATE TABLE IF NOT EXISTS IMC (id INTEGER PRIMARY KEY," +
                "data TEXT," +
                "hora TEXT," +
                "Peso REAL," +
                "Altura REAL, " +
                "Resultado REAL)";
        sqLiteDatabase.execSQL(banco);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private ContentValues getInfoimc(CalcularIMC imc) {

        ContentValues dados = new ContentValues();

        dados.put("data", imc.getData());
        dados.put("hora", imc.getHora());
        dados.put("Peso", imc.getPeso());
        dados.put("Altura", imc.getAltura());
        dados.put("Resultado", imc.getResultado());

        return dados;
    }

    public void inserirIMC(CalcularIMC imc) {
        SQLiteDatabase bancoSQL = getWritableDatabase();
        ContentValues dados = getInfoimc(imc);
        bancoSQL.insert("IMC", null, dados);
        Log.d("SalvandoDados", "Dados inseridos no banco: " + dados);
    }

    public CalcularIMC BuscarIMC() {
        String banco = "SELECT * FROM IMC WHERE id = (SELECT MAX(id) FROM IMC);";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        CalcularIMC calcular = new CalcularIMC();

        while (cursor.moveToNext()) {
            CalcularIMC imc = new CalcularIMC();
            imc.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            imc.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            imc.setHora(cursor.getString(cursor.getColumnIndexOrThrow("hora")));
            imc.setPeso((float) cursor.getDouble(cursor.getColumnIndexOrThrow("Peso")));
            imc.setAltura((float) cursor.getDouble(cursor.getColumnIndexOrThrow("Altura")));
            imc.setResultado((float) cursor.getDouble(cursor.getColumnIndexOrThrow("Resultado")));

        }
        cursor.close();

        return calcular;
    }

    public List<CalcularIMC> buscarHistoricoIMC() {
        String banco = "SELECT * FROM IMC;";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        List<CalcularIMC> historicoIMC = new ArrayList<CalcularIMC>();

        while (cursor.moveToNext()) {
            CalcularIMC imc = new CalcularIMC();

            imc.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            imc.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            imc.setHora(cursor.getString(cursor.getColumnIndexOrThrow("hora")));
            imc.setPeso( cursor.getFloat(cursor.getColumnIndexOrThrow("Peso")));
            imc.setAltura( cursor.getFloat(cursor.getColumnIndexOrThrow("Altura")));
            imc.setResultado( cursor.getFloat(cursor.getColumnIndexOrThrow("Resultado")));

            historicoIMC.add(imc);
        }
        cursor.close();

        return historicoIMC;
    }
}
