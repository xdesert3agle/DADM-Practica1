package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pregunta6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta6);

        // Recuperación del array de la pantalla anterior
        final List<String> respuestas = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(respuestas.get(0));

        final CheckBox opcion1 = (CheckBox) findViewById(R.id.respuesta1);
        final CheckBox opcion2 = (CheckBox) findViewById(R.id.respuesta2);
        final CheckBox opcion3 = (CheckBox) findViewById(R.id.respuesta3);
        final CheckBox opcion4 = (CheckBox) findViewById(R.id.respuesta4);
        final CheckBox opcion5 = (CheckBox) findViewById(R.id.respuesta5);

        Button btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!opcion1.isChecked() && !opcion2.isChecked() && !opcion3.isChecked() && !opcion4.isChecked() && !opcion5.isChecked()){
                    Toast.makeText(Pregunta6.this, "Debes marcar al menos una respuesta", Toast.LENGTH_SHORT).show();
                }
                else{
                    respuestas.set(6, getChecked(opcion1, opcion2, opcion3, opcion4, opcion5));

                    Intent intent = new Intent(Pregunta6.this, Pregunta7.class);
                    intent.putExtra("info", (ArrayList<String>) respuestas);

                    startActivity(intent);
                }

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

    private String getChecked(CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4, CheckBox op5){
        StringBuilder stringBuilder = new StringBuilder();

        if (op1.isChecked()){
            stringBuilder.append(op1.getText().toString()).append(", ");
        }
        if (op2.isChecked()){
            stringBuilder.append(op2.getText().toString()).append(", ");
        }
        if (op3.isChecked()){
            stringBuilder.append(op3.getText().toString()).append(", ");
        }
        if (op4.isChecked()){
            stringBuilder.append(op4.getText().toString()).append(", ");
        }
        if (op5.isChecked()){
            stringBuilder.append(op5.getText().toString());
        }

        if (!op5.isChecked()){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        Log.d("String final", stringBuilder.toString());
        Log.d("Longitud string", String.valueOf(stringBuilder.length()));
        return stringBuilder.toString();
    }
}
