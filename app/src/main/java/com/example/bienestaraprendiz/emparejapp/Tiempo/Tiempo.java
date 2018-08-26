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


}
