package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Pregunta9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta9);

        // Recuperación del array de la pantalla anterior
        final List<String> respuestas = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(respuestas.get(0));

        Button btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton boton = (ToggleButton) findViewById(R.id.respuesta);

                respuestas.set(9, boton.getText().toString());
                Intent intent = new Intent(Pregunta9.this, Pregunta10.class);

                intent.putExtra("info", (ArrayList<String>) respuestas);
                startActivity(intent);
            }
        });

        Button btn_Prev = (Button) findViewById(R.id.btnPrev);
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
