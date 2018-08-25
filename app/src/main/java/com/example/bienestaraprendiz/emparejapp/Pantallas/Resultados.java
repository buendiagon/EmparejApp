package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.R;

public class Resultados extends AppCompatActivity {
    String player1,player2,puntaje1,puntaje2;
    TextView jugador1,jugador2,score1,score2,tiempo1,tiempo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
    }
}
