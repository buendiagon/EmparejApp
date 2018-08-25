package com.example.bienestaraprendiz.emparejapp.Entidades;

public class PuntajesVo {
    String nombre,puntaje;

    public PuntajesVo(String nombre, String puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
