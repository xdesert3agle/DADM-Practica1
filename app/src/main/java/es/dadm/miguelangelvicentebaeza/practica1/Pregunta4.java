package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pregunta4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4);

        // Recuperación del array de la pantalla anterior
        final List<String> info = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(info.get(0));

        Button btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner respuestas = (Spinner) findViewById(R.id.respuestas);
                String respuesta = respuestas.getSelectedItem().toString();

                info.set(4, respuesta);

                Intent intent = new Intent(Pregunta4.this, Pregunta5.class);
                intent.putExtra("info", (ArrayList<String>) info);

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
