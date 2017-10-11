package com.htcdiurno.aceptapolitica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {

    private boolean flag;
    private String edad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        TextView txtMensaje =(TextView)findViewById(R.id.texto);
        Bundle bundle = getIntent().getExtras();
        txtMensaje.setText( "Hola "+ bundle.getString("NOMBRE")+
                " ¿Aceptas la política de privacidad?");

        edad=bundle.getString("EDAD");

        Button btAct2 = (Button)findViewById(R.id. button2);
        btAct2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                volverMain(edad);
            }
        });

        Button btAct3 = (Button)findViewById(R.id. button3);
        btAct3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=false;
                volverMain(edad);
            }
        });
    }

    public void volverMain(String edad){

        Intent intent= new Intent (this, AceptaPolitica. class);
        Bundle bundle = new Bundle();

        if(flag) {

            if (Integer.parseInt(edad) < 18)
                bundle.putString("OPCION", "Aceptada con restricciones.");
            else
                bundle.putString("OPCION", "Aceptada sin restricciones.");

        }else
            bundle.putString( "OPCION", "Rechazada");

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();

    }

}
