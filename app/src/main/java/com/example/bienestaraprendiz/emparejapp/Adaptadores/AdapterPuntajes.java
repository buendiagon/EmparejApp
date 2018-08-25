package com.example.bienestaraprendiz.emparejapp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.Entidades.ListaVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterPuntajes extends RecyclerView.Adapter<AdapterPuntajes.listaViewHolder> {
    ArrayList<ListaVo> lista;
    public AdapterPuntajes(ArrayList<ListaVo> lista) {
        this.lista = lista;
    }
    @NonNull
    @Override
    public AdapterPuntajes.listaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        return new listaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPuntajes.listaViewHolder listaViewHolder, int i) {
        listaViewHolder.player1.setText(lista.get(i).getPlayer1());listaViewHolder.player2.setText(lista.get(i).getPlayer2());listaViewHolder.player3.setText(lista.get(i).getPlayer3());listaViewHolder.player4.setText(lista.get(i).getPlayer4());listaViewHolder.player5.setText(lista.get(i).getPlayer5());
        listaViewHolder.puntaje1.setText(lista.get(i).getPuntaje1());listaViewHolder.puntaje2.setText(lista.get(i).getPuntaje2());listaViewHolder.puntaje3.setText(lista.get(i).getPuntaje3());listaViewHolder.puntaje4.setText(lista.get(i).getPuntaje4());listaViewHolder.puntaje5.setText(lista.get(i).getPuntaje5());
        if(i==0)listaViewHolder.titulo.setText("Fácil");
        else if(i==1)listaViewHolder.titulo.setText("Medio");
        else if(i==2)listaViewHolder.titulo.setText("Difícil");
        else if(i==3)listaViewHolder.titulo.setText("Fácil con tiempo");
        else if(i==4)listaViewHolder.titulo.setText("Medio con tiempo");
        else if(i==5)listaViewHolder.titulo.setText("Difícil con tiempo");
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class listaViewHolder extends RecyclerView.ViewHolder {
        TextView player1,player2,player3,player4,player5,puntaje1,puntaje2,puntaje3,puntaje4,puntaje5,tiempo1,tiempo2,tiempo3,tiempo4,tiempo5,titulo;
        public listaViewHolder(@NonNull View itemView) {
            super(itemView);
            player1=itemView.findViewById(R.id.jugador1);player2=itemView.findViewById(R.id.jugador2);player3=itemView.findViewById(R.id.jugador3);player4=itemView.findViewById(R.id.jugador4);player5=itemView.findViewById(R.id.jugador5);
            puntaje1=itemView.findViewById(R.id.score1);puntaje2=itemView.findViewById(R.id.score2);puntaje3=itemView.findViewById(R.id.score3);puntaje4=itemView.findViewById(R.id.score4);puntaje5=itemView.findViewById(R.id.score5);
            titulo=itemView.findViewById(R.id.titulo);
        }
    }
}