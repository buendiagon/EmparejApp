package com.example.bienestaraprendiz.emparejapp.Tiempo;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

public class Tiempo {

    long detenerse;
    Boolean running = false;

    public  void iniciarcrhonometro(Chronometer chronometro){

        if (!running)
        chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
        chronometro.start();
        running = true;
    }

    public void pausarchronometro(Chronometer chronometro){

        if(running){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            running = false;
        }
    }

    public void reiniciarchronometro(Chronometer chronometro){
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        running = false;
        chronometro.stop();

    }

    public void temporizador(int minutos, int segundos, final TextView mostrar){
        int minu= (minutos*60)*1000;
        int segu= segundos*1000;
        long valor= minu + segu;
        CountDownTimer temporizador = new CountDownTimer(valor,1000) {
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

            }
        }.start();
    }
}
