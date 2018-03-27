package es.dadm.miguelangelvicentebaeza.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resultado extends AppCompatActivity {
    TextView txt_Corrects;
    TextView txt_Incorrects;
    TextView txt_CorrectQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Recuperación del array de la pantalla anterior
        final List<String> respuestas = getIntent().getExtras().getStringArrayList("info");

        // Array nuevo que contiene las respuestas correctas a cada pregunta
        final List<String> correctas = getRespuestasCorrectas();

        txt_Corrects = (TextView) findViewById(R.id.txt_Corrects);
        txt_Incorrects = (TextView) findViewById(R.id.txt_Incorrects);

        TextView txt_FinalMsg = (TextView) findViewById(R.id.txt_FinalMsg);
        txt_FinalMsg.setText(txt_FinalMsg.getText().toString().replaceAll("username", respuestas.get(0)));

        txt_CorrectQuestions = (TextView) findViewById(R.id.txt_CorrectQuestions);
        txt_CorrectQuestions = (TextView) findViewById(R.id.txt_CorrectQuestions);

        getResultados(respuestas, correctas);

        Button btn_StartAgain = (Button) findViewById(R.id.btn_StartAgain);
        btn_StartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private List<String> getRespuestasCorrectas(){
        List<String> correctas = new ArrayList<>();

        for (int i = 0; i < 11; i++)
            correctas.add("");

        correctas.set(1, "Cupcake");
        correctas.set(2, "2007");
        correctas.set(3, "HTC Dream");
        correctas.set(4, "Sony");
        correctas.set(5, "Android Wear");
        correctas.set(6, "1");
        correctas.set(7, "8 modelos");
        correctas.set(8, "Ice Cream Sandwich");
        correctas.set(9, "Verdadero");
        correctas.set(10, "2007");

        return correctas;
    }

    /* Añade a los TextView txt_Corrects y txt_Incorrects los aciertos y los fallos respectivamente que ha tenido el usuario,
       además de actualizar el marcador con el número de aciertos. */
    private void getResultados(List <String> respuestasUsuario, List <String> respuestasCorrectas){
        int aciertos = 0;

        // Elimina los placeholders
        txt_Corrects.setText("");
        txt_Incorrects.setText("");

        for (int i = 1; i <= 10; i++){
            if (respuestasUsuario.get(i).equals(respuestasCorrectas.get(i))){
                txt_Corrects.append("Pregunta " + i + "\n");
                aciertos++;
            } else {
                txt_Incorrects.append("Pregunta " + i + "\n");
            }
        }
        txt_CorrectQuestions.setText(String.valueOf(aciertos));
    }
}