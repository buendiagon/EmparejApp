package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    String player1,player2,puntaje1,puntaje2,tiempo1,tiempo2,player3,puntaje3;
    TextView jugador1,jugador2,score1,score2,time1,time2;
    Button volver;
    int validar=0;
    int nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");
        puntaje1=getIntent().getStringExtra("puntaje1");
        puntaje2=getIntent().getStringExtra("puntaje2");
        /*
        tiempo1=getIntent().getStringExtra("tiempo1");
        tiempo2=getIntent().getStringExtra("tiempo2");
        */
        nivel=getIntent().getIntExtra("nivel",0);

        jugador1=findViewById(R.id.player1);
        jugador2=findViewById(R.id.player2);
        score1=findViewById(R.id.puntaje1);
        score2=findViewById(R.id.puntaje2);
        time1=findViewById(R.id.tiempo1);
        time2=findViewById(R.id.tiempo2);

        jugador1.setText(player1);
        jugador2.setText(player2);
        score1.setText(puntaje1);
        score2.setText(puntaje2);
        player3=player1;
        puntaje3=puntaje1;
        /*
        time1.setText(tiempo1);
        time2.setText(tiempo2);
        */
        VerificarBD();
    }
    private void VerificarBD(){
        ArrayList<PuntajesVo> lista;
        lista=new ArrayList<>();
        ContentValues registro=new ContentValues();
        ContentValues registro1=new ContentValues();
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.consultar(this,"tb_puntaje",lista);
        for(int i=0;i<5;i++){
            if(Integer.valueOf(puntaje3)>=Integer.valueOf(lista.get(i+((nivel-1)*5)).getPuntaje())){
                for(int j=i;j<4;j++){
                    registro1.put("nombre",lista.get(j+((nivel-1)*5)).getNombre());
                    registro1.put("puntaje",lista.get(j+((nivel-1)*5)).getPuntaje());
                    crud.modificar(this,"tb_puntaje",registro1,String.valueOf(i+((nivel-1)*5)+2));
                    Log.d("verificar",lista.get(j+((nivel-1)*5)).getNombre());
                }

                registro.put("nombre",player3);
                registro.put("puntaje",puntaje3);
                crud.modificar(this,"tb_puntaje",registro,String.valueOf(i+((nivel-1)*5)+1));
                validar++;
                if(validar==2) break;
                player3=player2;
                puntaje3=puntaje2;
                VerificarBD();
                break;
            }
        }
    }
}
