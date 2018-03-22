package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Pregunta1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);

        // Recuperamos el array enviado en la pantalla principal, y ponemos el nombre del usuario de bajo del avatar.
        final List<String> info = getIntent().getExtras().getStringArrayList("info");
        TextView avatar_username = (TextView) findViewById(R.id.username);
        avatar_username.setText(info.get(0));

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.respuestas);
        radioGroup.check(R.id.respuesta1); // El primer radioButton viene checkeado por defecto para evitar que se deje en blanco.

        Button btnSiguiente = (Button) findViewById(R.id.btnNext);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton elegida = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                info.set(1, elegida.getText().toString());

                Intent intent = new Intent(Pregunta1.this, Pregunta2.class);
                intent.putExtra("info", (ArrayList<String>) info);

                startActivity(intent);
            }
        });
    }
}
