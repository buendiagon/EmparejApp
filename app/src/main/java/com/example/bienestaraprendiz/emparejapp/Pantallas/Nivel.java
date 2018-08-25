package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Nivel extends AppCompatActivity {
    Button facil,medio,dificil;
    String player1,player2;
    int nivel=0;
    ArrayList<PuntajesVo> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        lista=new ArrayList<>();
        facil=findViewById(R.id.facil);
        medio=findViewById(R.id.medio);
        dificil=findViewById(R.id.dificil);
        player1=getIntent().getStringExtra("jugadoruno");
        player2=getIntent().getStringExtra("jugadordos");
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.consultar(this,"tb_tiempo",lista);

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=1;
                if(Integer.valueOf(lista.get(0).getTiempo())==1){
                    nivel=nivel+3;
                }
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);
                finish();
            }
        });
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=2;
                if(Integer.valueOf(lista.get(0).getTiempo())==1){
                    nivel=nivel+3;
                }
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);
                finish();

            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nivel=3;
                if(Integer.valueOf(lista.get(0).getTiempo())==1){
                    nivel=nivel+3;
                }
                Intent intent=new Intent(Nivel.this,Juego.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("nivel",nivel);
                startActivity(intent);
                finish();
            }
        });
    }
}
