package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Pregunta10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta10);

        // Recuperación del array de la pantalla anterior
        final List<String> respuestas = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(respuestas.get(0));

        // Instanciamos el NumberPicker para poder asignarle los valores mínimo y máximo
        final NumberPicker respuesta = (NumberPicker) findViewById(R.id.respuesta);
        respuesta.setMinValue(2006);
        respuesta.setMaxValue(2010);
        respuesta.setWrapSelectorWheel(false); // Sin scroll infinito

        Button btn_End = (Button) findViewById(R.id.btn_EndQuiz);
        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuestas.set(10, Integer.toString(respuesta.getValue()));

                Intent intent = new Intent(Pregunta10.this, Resultado.class);
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
