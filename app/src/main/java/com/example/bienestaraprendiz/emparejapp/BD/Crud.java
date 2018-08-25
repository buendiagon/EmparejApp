package com.example.bienestaraprendiz.emparejapp.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;

import org.apache.http.conn.ConnectTimeoutException;

import java.util.ArrayList;

public class Crud extends SQLiteOpenHelper {
    public Crud(Context context, String name,SQLiteDatabase.OpenParams openParams,int version) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id primary key autoincrement,tiempo text,siTiempo int)");
        ContentValues registro =new ContentValues();
        registro.put("nombre","nadie");
        registro.put("puntaje","0");
        for (int i=0;i<29;i++){
            db.insert("tb_puntaje",null,registro);
        }
        ContentValues registro1=new ContentValues();
        registro1.put("tiempo","0");
        registro1.put("siTiempo","0");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("drop table if exists tb_tiempo");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id primary key autoincrement,tiempo text,siTiempo int)");
    }
    public void iniciarBD(Context context){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
    }
    public void modificar(Context context,String table,ContentValues registro,String id){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.update(table,registro,"id="+id,null);
    }
    public void consultar(Context context,String table ,ArrayList<PuntajesVo> lista){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+table,null);
        while (cursor.moveToNext()){
            lista.add(new PuntajesVo(cursor.getString(1),cursor.getString(2)));
        }
        cursor.close();

    }
}
