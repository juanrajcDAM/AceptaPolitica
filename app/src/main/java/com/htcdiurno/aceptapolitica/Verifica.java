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

        /*Al crearse la activity Verifica, mostrará el nombre que le hemos pasado desde
        la activity AceptaPolitica*/
        TextView txtMensaje =(TextView)findViewById(R.id.texto);
        Bundle bundle = getIntent().getExtras();
        txtMensaje.setText( "Hola "+ bundle.getString("NOMBRE")+
                " ¿Aceptas la política de privacidad?");

        edad=bundle.getString("EDAD");

        /*Asignamos el botón de aceptar a un tipo Button, con el que posteriormente
        le crearemos un oyente.*/
        Button btAct2 = (Button)findViewById(R.id. button2);
        btAct2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                volverMain(edad);
            }
        });

        /*Asignamos el botón de rechazar a un tipo Button, con el que posteriormente
        le crearemos un oyente.*/
        Button btAct3 = (Button)findViewById(R.id. button3);
        btAct3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=false;
                volverMain(edad);
            }
        });
    }

    /**
     * El método devolverá los datos de la opción seleccionada en la activity Verifica
     * a la activity AceptaPolítica. Se le pasará por parámetro la edad en tipo String.
     */
    public void volverMain(String edad){

        Intent intent= new Intent (this, AceptaPolitica. class);
        Bundle bundle = new Bundle();

        //Comprobamos con una bandera de tipo booleano la opción seleccionada (aceptada o rechazada).
        if(flag) {

            /*Comprobamos también la edad introducida previamente en la activity AceptaPolitica.
            Mostraremos un mensaje diferente dependiendo de si es mayor o menor de edad.*/
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
