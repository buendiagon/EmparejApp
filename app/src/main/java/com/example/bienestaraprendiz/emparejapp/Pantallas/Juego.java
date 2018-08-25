package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView player1,player2,puntaje1,puntaje2,tiempo;
    ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,imagen8,imagen9,imagen10,imagen11,imagen12,imagen13,imagen14,imagen15,imagen16;
    ArrayList<ImageView> Ids;
    ArrayList<Integer> images;
    ArrayList<Integer> acomodar;
    int nivel,ran=-1,aleatorio=0,click=0,anterior=0,anterior1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nivel=getIntent().getIntExtra("nivel",0);
        Ids=new ArrayList<>();
        images=new ArrayList<>();
        acomodar=new ArrayList<>();
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
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        puntaje1=findViewById(R.id.puntaje1);
        puntaje2=findViewById(R.id.puntaje2);
        tiempo=findViewById(R.id.tempo);
        //asignar nombre y puntaje del intent


        //Array de identificacion de las imagenes
        Ids.add(imagen1=findViewById(R.id.imagen1));Ids.add(imagen2=findViewById(R.id.imagen2));Ids.add(imagen3=findViewById(R.id.imagen3));Ids.add(imagen4=findViewById(R.id.imagen4));Ids.add(imagen5=findViewById(R.id.imagen5));Ids.add(imagen6=findViewById(R.id.imagen6));Ids.add(imagen7=findViewById(R.id.imagen7));Ids.add(imagen8=findViewById(R.id.imagen8));
        //Array de las imagenes
        images.add(R.drawable.imagen1);
        images.add(R.drawable.imagen2);
        images.add(R.drawable.imagen3);
        images.add(R.drawable.imagen4);
        images.add(R.drawable.imagen5);
        images.add(R.drawable.imagen6);
        images.add(R.drawable.imagen7);
        images.add(R.drawable.imagen8);
        images.add(R.drawable.imagen);


        ReiniciarImages(0);
        IniciarImages();
    }

    private void ReiniciarImages(int donde) {
        int j=0;
        if(nivel==1 || nivel==4){
            j=8;
        }else if(nivel==2 || nivel==5){
            j=12;
        }else if(nivel==3 || nivel==6){
            j=16;
        }
        for(int i=0;i<j;i++){
            if(donde==0){
                acomodar.add(images.get(8));
                Ids.get(i).setImageResource(images.get(8));
            }
            else {
                Ids.get(i).setImageResource(images.get(8));
            }

        }
    }
    private void IniciarImages(){
        Random rnd=new Random();
        int cartas=0;
        if(nivel==1){
            cartas=4;
            aleatorio=8;
        }else if(nivel==2){
            cartas=6;
            aleatorio=12;
        }else if(nivel==3){
            cartas=8;
            aleatorio=16;
        }
        for(int z=0;z<2;z++){
            ran=rnd.nextInt(aleatorio);
            for(int i=0;i<cartas;i++){
                while(!acomodar.get(ran).equals(images.get(8))){
                    ran=rnd.nextInt(aleatorio);
                }
                acomodar.set(ran,images.get(i));
            }
        }
    }
    public void Voltear(View view){
        ImageView imagen=findViewById(view.getId());
        int si=0;
        for(int i=0;i<aleatorio;i++){
            if(view.getId()==Ids.get(i).getId()){
                imagen.setImageResource(acomodar.get(i));
                if(view.getId()!=anterior){
                    click++;
                    if(acomodar.get(i)==anterior1){
                        si=1;
                        SegClick(si,view,anterior);
                        anterior1=acomodar.get(i);
                    }else {
                        anterior1=acomodar.get(i);
                        SegClick(si,view,anterior);
                    }
                    anterior=view.getId();
                }
                break;
            }
        }

    }
    private void SegClick(final int si, final View view, final int imagenAnterior){
        if(click==2){
            click=0;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(si==1){
                        findViewById(view.getId()).setVisibility(view.INVISIBLE);
                        findViewById(imagenAnterior).setVisibility(view.INVISIBLE);
                    }
                    anterior=0;
                    anterior1=0;
                    for(int i=0;i<aleatorio;i++){
                        Ids.get(i).setEnabled(true);
                    }
                    ReiniciarImages(1);
                }
            },1000);
            for(int i=0;i<aleatorio;i++){
                Ids.get(i).setEnabled(false);
            }
        }
    }
}
