package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pregunta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        // Recuperamos el array enviado en la pantalla anterior, y ponemos el nombre del usuario debajo del avatar en pantalla.
        final List<String> info = getIntent().getExtras().getStringArrayList("info");
        TextView txt_Username = (TextView) findViewById(R.id.username);
        txt_Username.setText(info.get(0));

        Button btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText respuesta = (EditText) findViewById(R.id.respuesta);

                if (respuesta.getText().toString().length() != 4){
                    Toast.makeText(Pregunta2.this, "Introduce una respuesta de 4 dígitos.", Toast.LENGTH_SHORT).show();
                }
                else{
                    info.set(2, respuesta.getText().toString());

                    Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
                    intent.putExtra("info", (ArrayList<String>) info);

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
}