package es.dadm.miguelangelvicentebaeza.practica1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Resultado extends AppCompatActivity {
    List<String> userAns;
    List<String> correctAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Recuperación del array de la pantalla anterior
        userAns = getIntent().getExtras().getStringArrayList("info");

        // Array nuevo que contiene las respuestas correctas de cada pregunta
        correctAns = getRespuestasCorrectas();

        // Escribimos el nombre del usuario en el mensaje final
        TextView txt_YourResultIs = (TextView) findViewById(R.id.txt_YourResultIs);
        txt_YourResultIs.setText(txt_YourResultIs.getText().toString().replaceAll("username", userAns.get(0)));

        getResults();

        Button btn_StartAgain = (Button) findViewById(R.id.btn_StartAgain);
        btn_StartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultado.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private List<String> getRespuestasCorrectas(){
        List<String> correctas = new ArrayList<>();

        for (int i = 0; i < 11; i++)
            correctas.add("");

        correctas.set(1, "Cupcake");
        correctas.set(2, "2005");
        correctas.set(3, "HTC Dream");
        correctas.set(4, "Sony");
        correctas.set(5, "Android Wear");
        correctas.set(6, "Chupachup, Lime Cake");
        correctas.set(7, "8 " + getResources().getString(R.string.models));
        correctas.set(8, "Ice Cream Sandwich");
        correctas.set(9, getResources().getString(R.string.txt_ToggleTrue));
        correctas.set(10, "2008");

        return correctas;
    }

    private void getResults(){
        int correctas = 0;

        for (int i = 1; i <= 10; i++){
            TextView tvUserAns = (TextView) findViewById(getResources().getIdentifier("txt_Q" + i + "UserAns", "id", getPackageName()));
            tvUserAns.setText(tvUserAns.getText().toString().replaceAll("Lorem ipsum", userAns.get(i)));
            TextView tvCorrectAns = (TextView) findViewById(getResources().getIdentifier("txt_Q" + i + "CorrectAns", "id", getPackageName()));
            tvCorrectAns.setText(tvCorrectAns.getText().toString().replaceAll("Lorem ipsum", correctAns.get(i)));

            if (userAns.get(i).equals(correctAns.get(i))) {
                tvUserAns.setTextColor(ResourcesCompat.getColor(getResources(), R.color.material_green, null));
                correctas++;
            }
            else {
                tvUserAns.setTextColor(ResourcesCompat.getColor(getResources(), R.color.material_red, null));
            }
        }
        TextView tvFinalMsg = (TextView) findViewById(R.id.txt_Score);
        tvFinalMsg.setText(String.valueOf(correctas));
    }
}