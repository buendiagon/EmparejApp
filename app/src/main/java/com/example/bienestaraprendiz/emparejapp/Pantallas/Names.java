package com.example.bienestaraprendiz.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.R;

public class Names extends AppCompatActivity {
    EditText jugadoruno,jugadordos;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        jugadoruno = findViewById(R.id.jugadoruno);
        jugadordos = findViewById(R.id.jugadordos);
        ingresar = findViewById(R.id.ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niveles();
            }
        });
    }

    private void niveles() {
        if (jugadoruno.getText().toString().equals("") || jugadordos.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Por favor ingrese un nombre",Toast.LENGTH_SHORT).show();
        }else if (jugadoruno.getText().toString().equals(jugadordos.getText().toString())){
            Toast.makeText(getApplicationContext(),"Los nombres no pueden ser iguales",Toast.LENGTH_SHORT).show();
        }else{
            Intent pasar = new Intent(getApplicationContext(),Opciones.class);
                pasar.putExtra("jugadoruno",jugadoruno.getText().toString());
                pasar.putExtra("jugadordos",jugadordos.getText().toString());
            startActivity(pasar);
            finish();
        }
    }
}
