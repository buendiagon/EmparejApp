package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;
import com.example.bienestaraprendiz.emparejapp.Tiempo.Tiempo;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView player1,player2,puntaje1,puntaje2,tiempo;
    ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,imagen8,imagen9,imagen10,imagen11,imagen12,imagen13,imagen14,imagen15,imagen16;
    ArrayList<ImageView> Ids;
    ArrayList<Integer> images;
    ArrayList<Integer> acomodar;
    ArrayList<PuntajesVo> lista;
    TextView mostrar;
    int nivel,ran=-1,aleatorio=0,click=0,anterior=0,anterior1=0,nomRan=-1,parejas=0;
    String jugador1,jugador2;
    Chronometer time1,time2;
    long detenerse1=0;
    long detenerse2=0;
    CountDownTimer temporizador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lista=new ArrayList<>();
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.consultar(this,"tb_tiempo",lista);
        nivel=getIntent().getIntExtra("nivel",0);
        Ids=new ArrayList<>();
        images=new ArrayList<>();
        acomodar=new ArrayList<>();
        jugador1=getIntent().getStringExtra("player1");
        jugador2=getIntent().getStringExtra("player2");
        if(nivel==1 || nivel==4) {
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2 || nivel==5){
            setContentView(R.layout.medio);
            Ids.add(imagen9=findViewById(R.id.imagen9));Ids.add(imagen10=findViewById(R.id.imagen10));Ids.add(imagen11=findViewById(R.id.imagen11));Ids.add(imagen12=findViewById(R.id.imagen12));
        }
        else if(nivel==3 || nivel==6) {
            setContentView(R.layout.dificil);
            Ids.add(imagen9=findViewById(R.id.imagen9));Ids.add(imagen10=findViewById(R.id.imagen10));Ids.add(imagen11=findViewById(R.id.imagen11));Ids.add(imagen12=findViewById(R.id.imagen12));Ids.add(imagen13=findViewById(R.id.imagen13));Ids.add(imagen14=findViewById(R.id.imagen14));Ids.add(imagen15=findViewById(R.id.imagen15));Ids.add(imagen16=findViewById(R.id.imagen16));
        }
        time1=findViewById(R.id.time);
        time2=findViewById(R.id.time2);
        mostrar=findViewById(R.id.tempo);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        puntaje1=findViewById(R.id.puntaje1);
        puntaje2=findViewById(R.id.puntaje2);
        player1.setText(jugador1);
        player2.setText(jugador2);
        if(nivel<4){
            mostrar.setVisibility(View.INVISIBLE);
        }else {
            int minutos,segundos;
            minutos=Integer.valueOf(lista.get(0).getNombre());
            segundos=Integer.valueOf(lista.get(0).getPuntaje());
            temporizador(minutos,segundos,mostrar);

        }



        puntaje1.setText("0");
        puntaje2.setText("0");


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

        Random rnd=new Random();
        nomRan=rnd.nextInt(2)+1;
        nombres();


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
        if(nivel==1 || nivel==4){
            cartas=4;
            aleatorio=8;
        }else if(nivel==2 || nivel==5){
            cartas=6;
            aleatorio=12;
        }else if(nivel==3 || nivel==6){
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
                        parejas++;
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
                        if(nomRan==1){
                            puntaje1.setText(String.valueOf(Integer.valueOf(puntaje1.getText().toString())+100));
                        }
                        else puntaje2.setText(String.valueOf(Integer.valueOf(puntaje2.getText().toString())+100));
                    }
                    else {
                        if(nomRan==1){
                            nomRan=2;
                            puntaje1.setText(String.valueOf(Integer.valueOf(puntaje1.getText().toString())-2));
                        }
                        else if(nomRan==2){
                            nomRan=1;
                            puntaje2.setText(String.valueOf(Integer.valueOf(puntaje2.getText().toString())-2));
                        }
                        nombres();
                    }
                    anterior=0;
                    anterior1=0;
                    for(int i=0;i<aleatorio;i++){
                        Ids.get(i).setEnabled(true);
                    }
                    if(parejas==aleatorio/2){
                        Intent intent=new Intent(Juego.this,Resultados.class);
                        intent.putExtra("player1",player1.getText().toString());
                        intent.putExtra("player2",player2.getText().toString());
                        intent.putExtra("puntaje1",puntaje1.getText().toString());
                        intent.putExtra("puntaje2",puntaje2.getText().toString());
                        intent.putExtra("nivel",nivel);
                        Tiempo tiempoclass=new Tiempo();
                        tiempoclass.pausarchronometro(time1);
                        tiempoclass.pausarchronometro(time2);
                        intent.putExtra("time1",time1.getText().toString());
                        intent.putExtra("time2",time2.getText().toString());
                        if(nivel>3)temporizador.cancel();
                        //colocar tiempo

                        startActivity(intent);
                        finish();
                    }
                    ReiniciarImages(1);
                }
            },1000);
            for(int i=0;i<aleatorio;i++){
                Ids.get(i).setEnabled(false);
            }
        }
    }
    Tiempo tiempoclass=new Tiempo();
    private void nombres(){
        if(nomRan==1){
            detenerse2=tiempoclass.pausarchronometro(time2);
            tiempoclass.iniciarcrhonometro(time1,detenerse1);
            player1.setTextColor(Color.parseColor("#000000"));
            puntaje1.setTextColor(Color.parseColor("#000000"));
            player2.setTextColor(Color.parseColor("#808080"));
            puntaje2.setTextColor(Color.parseColor("#808080"));
        }
        else if(nomRan==2){
            detenerse1=tiempoclass.pausarchronometro(time1);
            tiempoclass.iniciarcrhonometro(time2,detenerse2);
            player2.setTextColor(Color.parseColor("#000000"));
            puntaje2.setTextColor(Color.parseColor("#000000"));
            player1.setTextColor(Color.parseColor("#808080"));
            puntaje1.setTextColor(Color.parseColor("#808080"));
        }
    }
    public void temporizador(int minutos, int segundos, final TextView mostrar){
        int minu= (minutos*60)*1000;
        int segu= segundos*1000;
        long valor= minu + segu;
        temporizador = new CountDownTimer(valor,1000) {
            @Override
            public void onTick(long l) {
                long tiempo = l / 1000;
                int min = (int) (tiempo / 60);
                long seg = tiempo % 60;
                String minutos = String.format("%02d",min);
                String segundos = String.format("%02d",seg);
                mostrar.setText(""+minutos+ " : "+segundos);

            }

            @Override
            public void onFinish() {
                mostrar.setText("Paila!");
                Intent intent=new Intent(Juego.this,Resultados.class);
                intent.putExtra("player1",player1.getText().toString());
                intent.putExtra("player2",player2.getText().toString());
                intent.putExtra("puntaje1",puntaje1.getText().toString());
                intent.putExtra("puntaje2",puntaje2.getText().toString());
                Tiempo tiempoclass=new Tiempo();
                tiempoclass.pausarchronometro(time1);
                tiempoclass.pausarchronometro(time2);
                intent.putExtra("time1",time1.getText().toString());
                intent.putExtra("time2",time2.getText().toString());

                intent.putExtra("nivel",nivel);
                    //colocar tiempo
                startActivity(intent);
                finish();

            }
        };
        temporizador.start();
    }
}
