package com.htcdiurno.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AceptaPolitica extends AppCompatActivity {

    private final static int CODIGO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Asignamos el botón de verificar a un tipo Button, con el que posteriormente
        le crearemos un oyente.*/
        Button btAct = (Button)findViewById(R.id. button);

        btAct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Antes de enviar los datos, comprobamos que la edad introducida es válida.
                if(compruebaEdad())
                    abrirVerifica();
                else {
                    //Si no es válida, se mostrará un mensaje en el campo textView.
                    TextView txtMensaje = (TextView) findViewById(R.id.textView);
                    txtMensaje.setText("EDAD NO VÁLIDA");
                }

            }
        });

    }

    /**
     * Según el resultado que devuelva la activity Verifica, mostrará un mensaje acorde.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO && resultCode == RESULT_OK) {

            TextView txtMensaje = (TextView)findViewById(R.id.textView);
            String res = data.getExtras().getString("OPCION");
            txtMensaje.setText("Resultado: " + res);

        }

    }

    /**
     * Envía los datos requeridos a la activity Verifica.
     */
    public void abrirVerifica(){

        EditText etNombre = (EditText)findViewById(R.id. editText);
        String nombre = etNombre.getText().toString();

        EditText etEdad = (EditText)findViewById(R.id. editText2);
        String edad = etEdad.getText().toString();

        Intent intent= new Intent (this, Verifica. class);
        Bundle bundle = new Bundle();
        bundle.putString( "NOMBRE", nombre);
        bundle.putString( "EDAD", edad);
        intent.putExtras(bundle);
        startActivityForResult(intent, CODIGO);
    }

    /**
     * Comprueba la validez del valor introducido en el campo Edad mediante la excepción
     * NumberFormatException. Devuelve un booleano.
     */
    private boolean compruebaEdad(){

        boolean valido=true;

        try {

            EditText comEdad = (EditText) findViewById(R.id.editText2);
            String edadCom = comEdad.getText().toString();
            int edadEntero = Integer.parseInt(edadCom);

        }catch(NumberFormatException nfe){
            valido=false;
        }

        return valido;

    }

}
