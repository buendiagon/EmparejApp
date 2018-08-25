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

    public Crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id integer primary key autoincrement,minutos text,segundos text,siTiempo integer)");
        ContentValues registro =new ContentValues();
        registro.put("nombre","nadie");
        registro.put("puntaje","0");
        registro.put("tiempo","0");
        for (int i=0;i<30;i++){
            db.insert("tb_puntaje",null,registro);
        }
        ContentValues registro1=new ContentValues();
        registro1.put("minutos","0");
        registro1.put("segundos","0");
        registro1.put("siTiempo","0");
        db.insert("tb_tiempo",null,registro1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("drop table if exists tb_tiempo");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id integer primary key autoincrement,minutos text,segundos text,siTiempo integer)");
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
