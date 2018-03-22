package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static es.dadm.miguelangelvicentebaeza.practica1.Util.*;

public class Pregunta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        // Recuperamos el array enviado en la pantalla principal, y ponemos el nombre del usuario de bajo del avatar.
        final List<String> info = getIntent().getExtras().getStringArrayList("info");
        TextView avatar_username = (TextView) findViewById(R.id.username);
        avatar_username.setText(info.get(0));

        Button btnSiguiente = (Button) findViewById(R.id.btnNext);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText respuesta = (EditText) findViewById(R.id.respuesta);

                if (!isNumber(respuesta.getText().toString()) || respuesta.getText().toString().length() != 4){
                    Toast.makeText(Pregunta2.this, "Sólo se pueden introducir números como respuesta.", Toast.LENGTH_SHORT).show();
                }
                else{
                    info.set(2, respuesta.getText().toString());

                    Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
                    intent.putExtra("info", (ArrayList<String>) info);

                    startActivity(intent);
                }
            }
        });
    }
}