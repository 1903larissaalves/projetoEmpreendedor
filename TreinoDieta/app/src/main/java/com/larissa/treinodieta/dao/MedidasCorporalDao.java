package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.MedidasCorporal;

import java.util.ArrayList;
import java.util.List;

public class MedidasCorporalDao extends SQLiteOpenHelper {

    static final int DB_VERSION = 5;

    public MedidasCorporalDao( Context context) {
        super(context, "MedidasCorporal", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String banco = "CREATE TABLE IF NOT EXISTS MedidasCorporal(id INTEGER PRIMARY KEY," +
                " data TEXT, " +
                " antebracoE TEXT," +
                " antebracoD TEXT," +
                " bracoE TEXT," +
                " bracoD TEXT," +
                " cintura TEXT," +
                " quadril TEXT," +
                " pernaE TEXT," +
                " pernaD TEXT," +
                " peito TEXT);";

        sqLiteDatabase.execSQL(banco);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String banco = "";
        switch (oldVersion){
            case 2:
                banco = "DROP TABLE MedidasCorporal";
                //banco = "ALTER TABLE MedidasCorporal ADD COLUMN data TEXT";
                db.execSQL(banco);

                onCreate(db);
            case 3:
                banco = "DROP TABLE MedidasCorporal";
                //banco = "ALTER TABLE MedidasCorporal ADD COLUMN data TEXT";
                db.execSQL(banco);

                onCreate(db);
            case 4:
                banco = "DROP TABLE MedidasCorporal";
                //banco = "ALTER TABLE MedidasCorporal ADD COLUMN data TEXT";
                db.execSQL(banco);

                onCreate(db);
        }
    }

    private ContentValues getInfoMedidasCorporal(MedidasCorporal medidasCorporal) {

        ContentValues dados = new ContentValues();

        dados.put("data", medidasCorporal.getData());
        dados.put("antebracoE", medidasCorporal.getAntebracoE());
        dados.put("antebracoD", medidasCorporal.getAntebracoD());
        dados.put("bracoE", medidasCorporal.getBracoE());
        dados.put("bracoD", medidasCorporal.getBracoD());
        dados.put("cintura", medidasCorporal.getCintura());
        dados.put("quadril", medidasCorporal.getQuadril());
        dados.put("pernaE", medidasCorporal.getPernaE());
        dados.put("pernaD", medidasCorporal.getPernaD());
        dados.put("peito", medidasCorporal.getPeito());

        return dados;
    }

    public void inserirMedidasCorporal(MedidasCorporal medidasCorporal) {
        SQLiteDatabase bancoSQL =  getWritableDatabase();
        ContentValues dados = getInfoMedidasCorporal(medidasCorporal);
        bancoSQL.insert("MedidasCorporal", null, dados);
    }


    public MedidasCorporal buscarMedidasCorporal() {
        String banco = "SELECT * FROM MedidasCorporal WHERE id = (SELECT MAX(id) FROM MedidasCorporal);";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        MedidasCorporal medidas = new MedidasCorporal();

        while (cursor.moveToNext()){

            medidas.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            medidas.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            medidas.setAntebracoE(cursor.getString(cursor.getColumnIndexOrThrow("antebracoE")));
            medidas.setAntebracoD(cursor.getString(cursor.getColumnIndexOrThrow("antebracoD")));
            medidas.setBracoE(cursor.getString(cursor.getColumnIndexOrThrow("bracoE")));
            medidas.setBracoD(cursor.getString(cursor.getColumnIndexOrThrow("bracoD")));
            medidas.setCintura(cursor.getString(cursor.getColumnIndexOrThrow("cintura")));
            medidas.setQuadril(cursor.getString(cursor.getColumnIndexOrThrow("quadril")));
            medidas.setPernaD(cursor.getString(cursor.getColumnIndexOrThrow("pernaD")));
            medidas.setPernaE(cursor.getString(cursor.getColumnIndexOrThrow("pernaE")));
            medidas.setPeito(cursor.getString(cursor.getColumnIndexOrThrow("peito")));

        }
        cursor.close();

        return medidas;
    }



    public List<MedidasCorporal> buscarHistoricoMedidasCorporal() {
        String banco = "SELECT * FROM MedidasCorporal;";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        List<MedidasCorporal> medidasHistorico = new ArrayList<MedidasCorporal>();

        while (cursor.moveToNext()){
            MedidasCorporal medidas = new MedidasCorporal();

            medidas.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            medidas.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            medidas.setAntebracoE(cursor.getString(cursor.getColumnIndexOrThrow("antebracoE")));
            medidas.setAntebracoD(cursor.getString(cursor.getColumnIndexOrThrow("antebracoD")));
            medidas.setBracoE(cursor.getString(cursor.getColumnIndexOrThrow("bracoE")));
            medidas.setBracoD(cursor.getString(cursor.getColumnIndexOrThrow("bracoD")));
            medidas.setCintura(cursor.getString(cursor.getColumnIndexOrThrow("cintura")));
            medidas.setQuadril(cursor.getString(cursor.getColumnIndexOrThrow("quadril")));
            medidas.setPernaD(cursor.getString(cursor.getColumnIndexOrThrow("pernaD")));
            medidas.setPernaE(cursor.getString(cursor.getColumnIndexOrThrow("pernaE")));
            medidas.setPeito(cursor.getString(cursor.getColumnIndexOrThrow("peito")));

            medidasHistorico.add(medidas);
        }
        cursor.close();

        return medidasHistorico;
    }

    public void deletar(MedidasCorporal medidasCorporal) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();
        String [] paramentros = {medidasCorporal.getId().toString()};
        mSQLiteDatabase.delete("MedidasCorporal", "id = ?", paramentros);
    }
}
