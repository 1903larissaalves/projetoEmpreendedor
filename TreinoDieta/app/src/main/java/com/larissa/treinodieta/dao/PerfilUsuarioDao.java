package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.larissa.treinodieta.models.PerfilUsuario;

public class PerfilUsuarioDao extends SQLiteOpenHelper {

    static final int DB_VERSION = 2;


    public PerfilUsuarioDao(Context context) {
        super(context, "PerfilUsuario", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabela = "CREATE TABLE IF NOT EXISTS PerfilUsuario (" +
                "id INTEGER PRIMARY KEY," +
                "data TEXT," +
                "senha TEXT," +
                "email TEXT," +
                "logado INTEGER," +
                "tipoPerfil TEXT);";
        sqLiteDatabase.execSQL(tabela);

        String admin = "INSERT INTO PerfilUsuario (email, senha) VALUES (\"admin\", \"123\");";
        sqLiteDatabase.execSQL(admin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    private ContentValues getInfoPerfilUsuario(PerfilUsuario perfilUsuario) {

        ContentValues dados = new ContentValues();
        dados.put("data", perfilUsuario.getData());
        dados.put("senha",perfilUsuario.getSenha());
        dados.put("email", perfilUsuario.getEmail());
        dados.put("tipoPerfil", perfilUsuario.getTipousuario());

        return dados;
    }

    public void inserirUsuario(PerfilUsuario perfilUsuario) {
        SQLiteDatabase bancoSQL =  getWritableDatabase();
        ContentValues dados = getInfoPerfilUsuario(perfilUsuario);
        bancoSQL.insert("PerfilUsuario", null, dados);
    }
    public boolean checkNomeUsuario(String email, String senha){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from PerfilUsuario where email = ? and senha = ?", new String[]{email,senha});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public boolean verificarAdminLogado() {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from PerfilUsuario where email = ? and logado = 1", new String[]{"admin"});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public void setarUsuarioLogado(String usuario) {
        SQLiteDatabase bancoSQL =  getWritableDatabase();

        String sql = "UPDATE PerfilUsuario SET logado = 0;";
        bancoSQL.execSQL(sql);

        sql = "UPDATE PerfilUsuario SET logado = 1 WHERE email = \"" + usuario + "\";";
        bancoSQL.execSQL(sql);
    }
}
