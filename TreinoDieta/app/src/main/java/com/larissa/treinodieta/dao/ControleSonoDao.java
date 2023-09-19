package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.ControleSono;

public class ControleSonoDao extends SQLiteOpenHelper {

    public ControleSonoDao(Context context) {
        super(context, "ControleSono", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabela = "CREATE TABLE IF NOT EXISTS ControleSono (" +
                "id INTEGER PRIMARY KEY," +
                "data TEXT," +
                "tempoDisponiveisSono REAL);";
        sqLiteDatabase.execSQL(tabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public ControleSono buscarTempoDisponiveisSono(String dataAtual) {
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.query("ControleSono",
                new String[]{"id", "data", "tempoDisponiveisSono"},
                "data = ?",
                new String[]{dataAtual},
                null, null, null);

        ControleSono controleSono = null;

        if (cursor.moveToFirst()) {
            controleSono = new ControleSono();
            controleSono.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            controleSono.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            controleSono.setTempoDisponiveisSono(cursor.getFloat(cursor.getColumnIndexOrThrow("tempoDisponiveisSono")));
        }

        cursor.close();

        return controleSono;
    }

    public void inserirControleSono(ControleSono controleSono) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();

        ContentValues dados = this.getDadosControleSono(controleSono);

        mSQLiteDatabase.insert("ControleSono", null, dados);
        mSQLiteDatabase.close();
    }

    public void atualizarControleSono(ControleSono controleSono) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();

        ContentValues dados = this.getDadosControleSono(controleSono);

        mSQLiteDatabase.update("ControleSono", dados, "data = ?",  new String[]{String.valueOf(controleSono.getData())});
        mSQLiteDatabase.close();
    }

    private ContentValues getDadosControleSono(ControleSono controleSono) {
        ContentValues dados = new ContentValues();

        dados.put("data", controleSono.getData());
        dados.put("tempoDisponiveisSono", controleSono.getTempoDisponiveisSono());

        return dados;
    }
}
