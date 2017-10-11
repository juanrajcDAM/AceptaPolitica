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

        Button btAct = (Button)findViewById(R.id. button);

        TextView txtMensaje = (TextView)findViewById(R.id.textView);
        txtMensaje.setText("Resultado: " );

        btAct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVerifica();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO && resultCode == RESULT_OK) {

            TextView txtMensaje = (TextView)findViewById(R.id.textView);
            String res = data.getExtras().getString("OPCION");
            txtMensaje.setText("Resultado: " + res);

        }

    }

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

}
