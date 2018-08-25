package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.Intent;
import android.graphics.Path;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.R;
import com.example.bienestaraprendiz.emparejapp.Tiempo.Tiempo;

public class Opciones extends AppCompatActivity {
    Button jugar,puntajes,configurar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        jugar = findViewById(R.id.jugar);
        puntajes = findViewById(R.id.puntajes);
        configurar = findViewById(R.id.configurar);




        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niveles();
            }
        });

        puntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scores();
            }
        });

        configurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configuracion();
            }
        });







    }

    private void configuracion() {
        Intent confi = new Intent(Opciones.this,Configuracion.class);
        startActivity(confi);
    }

    private void scores() {
        Intent ir = new Intent(Opciones.this,Puntajes.class);
        startActivity(ir);
    }

    private void niveles() {
        String jugadoruno = getIntent().getStringExtra("jugadoruno");
        String jugadordos = getIntent().getStringExtra("jugadordos");
        Intent pasar = new Intent(Opciones.this,Nivel.class);
        pasar.putExtra("jugadoruno",jugadoruno);
        pasar.putExtra("jugadordos",jugadordos);
        startActivity(pasar);

    }
}
