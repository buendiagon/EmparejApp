package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {
    TextView player1,player2,puntaje1,puntaje2,tiempo;
    ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,imagen8,imagen9,imagen10,imagen11,imagen12,imagen13,imagen14,imagen15,imagen16;
    ArrayList<ImageView> Ids;
    ArrayList<Integer> images;
    ArrayList<Integer> acomodar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Ids=new ArrayList<>();
        images=new ArrayList<>();
        acomodar=new ArrayList<>();
        player1=findViewById(R.id.player1);


        Ids.add(imagen1=findViewById(R.id.));


    }
}
