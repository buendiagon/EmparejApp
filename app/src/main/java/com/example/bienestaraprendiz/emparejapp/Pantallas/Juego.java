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
    int nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nivel=getIntent().getIntExtra("nivel",0);
        if(nivel==1) {
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2){
            setContentView(R.layout.medio);
            Ids.add(imagen9=findViewById(R.id.imagen9));Ids.add(imagen10=findViewById(R.id.imagen10));Ids.add(imagen11=findViewById(R.id.imagen11));Ids.add(imagen12=findViewById(R.id.imagen12));
        }
        else if(nivel==3) {
            setContentView(R.layout.dificil);
            Ids.add(imagen9=findViewById(R.id.imagen9));Ids.add(imagen10=findViewById(R.id.imagen10));Ids.add(imagen11=findViewById(R.id.imagen11));Ids.add(imagen12=findViewById(R.id.imagen12));Ids.add(imagen5=findViewById(R.id.imagen13));Ids.add(imagen6=findViewById(R.id.imagen14));Ids.add(imagen7=findViewById(R.id.imagen15));Ids.add(imagen8=findViewById(R.id.imagen16));
        }
        Ids=new ArrayList<>();
        images=new ArrayList<>();
        acomodar=new ArrayList<>();
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        puntaje1=findViewById(R.id.puntaje1);
        puntaje2=findViewById(R.id.puntaje2);
        tiempo=findViewById(R.id.tempo);
        //Array de identificacion de las imagenes
        Ids.add(imagen1=findViewById(R.id.imagen1));Ids.add(imagen2=findViewById(R.id.imagen2));Ids.add(imagen3=findViewById(R.id.imagen3));Ids.add(imagen4=findViewById(R.id.imagen4));Ids.add(imagen5=findViewById(R.id.imagen5));Ids.add(imagen6=findViewById(R.id.imagen6));Ids.add(imagen7=findViewById(R.id.imagen7));Ids.add(imagen8=findViewById(R.id.imagen8));

    }
}
