package com.example.bienestaraprendiz.emparejapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Pantallas.Names;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.iniciarBD(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pasar = new Intent(splashscreen.this,Names.class);
                startActivity(pasar);
                finish();
            }
        },3000);


    }
}
