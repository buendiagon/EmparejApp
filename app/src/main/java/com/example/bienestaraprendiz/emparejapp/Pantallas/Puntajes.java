package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.ListaVo;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Puntajes extends AppCompatActivity {
    ArrayList<PuntajesVo> lista;
    ArrayList<ListaVo> Puntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        lista=new ArrayList<>();
        Puntajes=new ArrayList<>();
        consulta();
    }
    private void consulta(){
        Crud  crud=new Crud(this,"puntaje",null,1);
        crud.consultar(this,"tb_puntaje",lista);
        for(int i=0;i<6;i++){
            
        }
    }
}
