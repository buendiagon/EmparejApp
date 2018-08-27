package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.ContentValues;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.BD.Crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Configuracion extends AppCompatActivity {

    CheckBox temporizador;
    EditText minutos,segundos;
    ImageView reloj;
    Button aplicar;
    int sitiempo = 0;
    Boolean estado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        temporizador = findViewById(R.id.temporizador);
        minutos = findViewById(R.id.minutos);
        segundos = findViewById(R.id.segundos);
        reloj = findViewById(R.id.reloj);
        aplicar = findViewById(R.id.aplicar);
        final Crud crud = new Crud(this,"puntaje",null,1);




//        consultar();

        temporizador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == false){
                    minutos.setEnabled(false);
                    segundos.setEnabled(false);
                    temporizador.setChecked(false);
                    minutos.setText("");
                    segundos.setText("");
                    estado = false;



                    sitiempo = 0;
                }else if (b == true){

                    minutos.setEnabled(true);
                    segundos.setEnabled(true);
                    temporizador.setChecked(true);
                    estado = true;

                    sitiempo = 1;

                }
            }
        });

        final ContentValues comoloquierallamar= new ContentValues();

        aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (estado == false && minutos.getText().toString().trim().equals("") && segundos.getText().toString().trim().equals("")){
//                        Toast.makeText(getApplicationContext(),"Por favor ingrese un valor",Toast.LENGTH_SHORT).show();
                        minutos.setText("0");
                        segundos.setText("0");
                        sitiempo = 0;
                        comoloquierallamar.put("minutos",minutos.getText().toString());
                        comoloquierallamar.put("segundos",segundos.getText().toString());
                        comoloquierallamar.put("siTiempo",String.valueOf(sitiempo));
                        crud.modificar(Configuracion.this,"tb_tiempo",comoloquierallamar,"1");
                        finish();

                    }else{

                             if (estado == true && Integer.valueOf(minutos.getText().toString()) == 0 && Integer.valueOf(segundos.getText().toString())  >= 60 || Integer.valueOf(segundos.getText().toString()) == 0){
                                 Toast.makeText(getApplicationContext(),"Por favor ingrese un valor valido",Toast.LENGTH_SHORT).show();
                             }else{
                                 comoloquierallamar.put("minutos",minutos.getText().toString());
                                 comoloquierallamar.put("segundos",segundos.getText().toString());
                                 comoloquierallamar.put("siTiempo",String.valueOf(sitiempo));
                                 crud.modificar(Configuracion.this,"tb_tiempo",comoloquierallamar,"1");
                                 finish();
                             }

                         }







                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"No pueden haber campos vacios",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

//    private void consultar() {
//        ArrayList<PuntajesVo> lista = new ArrayList<>();
//        Crud traer = new Crud(this,"puntaje",null,1);
//        traer.consultar(this,"tb_tiempo",lista);
//        int minutoss = Integer.valueOf(lista.get(0).getNombre());
//        int segundoss = Integer.valueOf(lista.get(0).getPuntaje());
//        int sitiempo = Integer.valueOf(lista.get(0).getTiempo());
//        Log.d("mirar", String.valueOf(sitiempo));
//
//
//
//    }
}
