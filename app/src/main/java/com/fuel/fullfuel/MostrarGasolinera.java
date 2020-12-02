package com.fuel.fullfuel;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MostrarGasolinera extends Activity {

    public TextView nombre;
    public TextView actualizacion;
    public TextView razon_social;
    public TextView direccion;
    public TextView comuna;

    public ImageView efectivo;
    public ImageView cheque;
    public ImageView bancarias;
    public ImageView tiendas;




    public Button button_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_gasolinera);
        final String nombre = (String) getIntent().getSerializableExtra("nombre");

        this.nombre = (TextView) findViewById(R.id.nombre);
        this.nombre.setText(nombre);


        actualizacion   = (TextView) findViewById(R.id.actualizacion);
        razon_social    = (TextView) findViewById(R.id.razon_social);;
        direccion       = (TextView) findViewById(R.id.direccion);;
        comuna          = (TextView) findViewById(R.id.comuna);;

        efectivo    = (ImageView) findViewById(R.id.efectivo);
        cheque      = (ImageView) findViewById(R.id.cheque);
        bancarias   = (ImageView) findViewById(R.id.bancarias);
        tiendas     = (ImageView) findViewById(R.id.tiendas);


        button_map = (Button) findViewById(R.id.button_map);
        button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsGasolineraActivity.class);
                i.putExtra("nombre", nombre);
                startActivity(i);
            }
        });

        this.mostrarDatosBasicos();
        this.mostrarMediosDePago();
    }

    public void mostrarDatosBasicos(){
        String actualizacion = (String) getIntent().getSerializableExtra("actualizacion");
        String razon_social = (String) getIntent().getSerializableExtra("razon_social");
        String direccion = (String) getIntent().getSerializableExtra("direccion");
        String comuna = (String) getIntent().getSerializableExtra("comuna");

        this.actualizacion.setText(actualizacion);
        this.razon_social.setText(razon_social);
        this.direccion.setText(direccion);
        this.comuna.setText(comuna);

    }

    public void mostrarMediosDePago(){
        Boolean efectivo = (Boolean) getIntent().getSerializableExtra("efectivo");
        Boolean cheque = (Boolean) getIntent().getSerializableExtra("cheque");
        Boolean bancarias = (Boolean) getIntent().getSerializableExtra("bancarias");
        Boolean tiendas = (Boolean) getIntent().getSerializableExtra("tiendas");

        if ((cheque)) {
            this.cheque.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.cheque.setImageResource(R.drawable.ic_falso);
        }
        if ((bancarias)) {
            this.bancarias.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.bancarias.setImageResource(R.drawable.ic_falso);
        }
        if ((tiendas)) {
            this.tiendas.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.tiendas.setImageResource(R.drawable.ic_falso);
        }

    }

    public void mostrarPrecios(){



        Boolean gasolina_93 = (Boolean) getIntent().getSerializableExtra("gasolina_93");
        Boolean gasolina_95 = (Boolean) getIntent().getSerializableExtra("gasolina_95");
        Boolean gasolina_97 = (Boolean) getIntent().getSerializableExtra("gasolina_97");
        Boolean pretroleo_diesel = (Boolean) getIntent().getSerializableExtra("pretroleo_diesel");
        Boolean glp_vehicular = (Boolean) getIntent().getSerializableExtra("glp_vehicular");


    }
}