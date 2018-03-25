package es.dadm.miguelangelvicentebaeza.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txt_name = (EditText) findViewById(R.id.txt_name);

        /* Instanciamos e inicializamos un array con 11 posiciones; una para el nombre del usuario, y las demás para los enunciados
        de las respuestas elegidas por el usuario. Así si el usuario responde una respuesta y elige retroceder a la anterior, con array.set
         podemos evitar que se guarde dos veces la respuesta a una pregunta en el mismo índice del array. */
        final List<String> info = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            info.add("");
        }

        Button btn_Start = (Button) findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, introduce tu nombre.", Toast.LENGTH_SHORT).show();
                }
                else {
                    info.set(0, txt_name.getText().toString());
                    Intent intent = new Intent(MainActivity.this, Pregunta1.class);
                    intent.putExtra("info", (ArrayList<String>) info);
                    startActivity(intent);
                }
            }
        });
    }
}
