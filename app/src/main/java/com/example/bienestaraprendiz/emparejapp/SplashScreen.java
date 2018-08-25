package com.example.bienestaraprendiz.emparejapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.iniciarBD(this);
    }
}
