package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.bienestaraprendiz.emparejapp.R;

public class Nivel extends AppCompatActivity {
    Button facil,medio,dificil;
    String player1,player2;
    int nivel=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        facil=findViewById(R.id.facil);
        medio=findViewById(R.id.medio);
        dificil=findViewById(R.id.dificil);
        player1=getIntent().getStringExtra("jugadoruno");
        player2=getIntent().getStringExtra("jugadordos");

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=1;
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);
            }
        });
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=2;
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);

            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=3;
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);
            }
        });
    }
}
