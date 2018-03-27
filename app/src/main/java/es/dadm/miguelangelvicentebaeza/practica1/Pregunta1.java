package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        // Recuperamos el array enviado en la pantalla principal, y ponemos el nombre del usuario debajo del avatar en pantalla.
        final List<String> respuestas = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(respuestas.get(0));

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.respuestas);
        radioGroup.check(R.id.respuesta1); // El primer radioButton viene checkeado por defecto para evitar que se deje en blanco.

        Button btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton elegida = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                respuestas.set(1, elegida.getText().toString());

                Intent intent = new Intent(Pregunta1.this, Pregunta2.class);
                intent.putExtra("info", (ArrayList<String>) respuestas);

                startActivity(intent);
            }
        });
    }
}
