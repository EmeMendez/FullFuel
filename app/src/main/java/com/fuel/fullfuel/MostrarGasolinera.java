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
    public TextView titulo_barra;
    public TextView nombre;
    public TextView actualizacion;
    public TextView razon_social;
    public TextView direccion;
    public TextView comuna;

    public ImageView efectivo;
    public ImageView cheque;
    public ImageView bancarias;
    public ImageView tiendas;

    public LinearLayout layout_93;
    public LinearLayout layout_95;
    public LinearLayout layout_97;
    public LinearLayout layout_diesel;
    public LinearLayout layout_glp;

    public TextView precio_93;
    public TextView precio_95;
    public TextView precio_97;
    public TextView precio_diesel;
    public TextView precio_glp;

    public ImageView tienda;
    public ImageView farmacia;
    public ImageView mantencion;
    public ImageView autoservicio;

    public TextView button_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_gasolinera);
        final String nombre = (String) getIntent().getSerializableExtra("nombre");

        this.nombre = (TextView) findViewById(R.id.nombre);
        this.nombre.setText(nombre);
        this.titulo_barra = (TextView) findViewById(R.id.titulo_barra);
        this.titulo_barra.setText("FULLFUEL - " + nombre);


        actualizacion   = (TextView) findViewById(R.id.actualizacion);
        razon_social    = (TextView) findViewById(R.id.razon_social);;
        direccion       = (TextView) findViewById(R.id.direccion);;
        comuna          = (TextView) findViewById(R.id.comuna);;

        efectivo    = (ImageView) findViewById(R.id.efectivo);
        cheque      = (ImageView) findViewById(R.id.cheque);
        bancarias   = (ImageView) findViewById(R.id.bancarias);
        tiendas     = (ImageView) findViewById(R.id.tiendas);

        layout_93   = (LinearLayout) findViewById(R.id.layout_93);
        layout_95   = (LinearLayout) findViewById(R.id.layout_95);
        layout_97   = (LinearLayout) findViewById(R.id.layout_97);
        layout_diesel = (LinearLayout) findViewById(R.id.layout_diesel);
        layout_glp = (LinearLayout) findViewById(R.id.layout_glp);

        precio_93    = (TextView) findViewById(R.id.precio_93);
        precio_95      = (TextView) findViewById(R.id.precio_95);
        precio_97   = (TextView) findViewById(R.id.precio_97);
        precio_diesel    = (TextView) findViewById(R.id.precio_diesel);
        precio_glp     = (TextView) findViewById(R.id.precio_glp);

        tienda    = (ImageView) findViewById(R.id.tienda);
        farmacia      = (ImageView) findViewById(R.id.farmacia);
        mantencion   = (ImageView) findViewById(R.id.mantencion);
        autoservicio     = (ImageView) findViewById(R.id.autoservicio);

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
        this.mostrarPrecios();
        this.mostrarServicios();
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
        String gasolina_93 = (String) getIntent().getSerializableExtra("gasolina_93");
        String gasolina_95 = (String) getIntent().getSerializableExtra("gasolina_95");
        String gasolina_97 = (String) getIntent().getSerializableExtra("gasolina_97");
        String pretroleo_diesel = (String) getIntent().getSerializableExtra("pretroleo_diesel");
        String glp_vehicular = (String) getIntent().getSerializableExtra("glp_vehicular");


        if(gasolina_93 == null){
            this.layout_93.setVisibility(View.GONE);

        }else{
            this.precio_93.setText( "$ " + gasolina_93);
            this.layout_93.setVisibility(View.VISIBLE);
        }

        if(gasolina_95 == null){
            this.layout_95.setVisibility(View.GONE);
        }else{
            this.precio_95.setText("$ " + gasolina_95);
            this.layout_95.setVisibility(View.VISIBLE);
        }

        if(gasolina_97 == null){
            this.layout_97.setVisibility(View.GONE);
        }else{
            this.precio_97.setText("$ " + gasolina_97);
            this.layout_97.setVisibility(View.VISIBLE);
        }

        if(pretroleo_diesel == null){
            this.layout_diesel.setVisibility(View.GONE);
        }else{
            this.precio_diesel.setText("$ " + pretroleo_diesel);
            this.layout_diesel.setVisibility(View.VISIBLE);
        }

        if(glp_vehicular == null){
            this.layout_glp.setVisibility(View.GONE);
        }else{
            this.precio_glp.setText("$ " + glp_vehicular);
            this.layout_glp.setVisibility(View.VISIBLE);
        }

    }

    public void mostrarServicios(){
        Boolean tienda = (Boolean) getIntent().getSerializableExtra("tienda");
        Boolean farmacia = (Boolean) getIntent().getSerializableExtra("farmacia");
        Boolean mantencion = (Boolean) getIntent().getSerializableExtra("mantencion");
        Boolean autoservicio = (Boolean) getIntent().getSerializableExtra("autoservicio");

        if ((tienda)) {
            this.tienda.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.tienda.setImageResource(R.drawable.ic_falso);
        }

        if ((farmacia)) {
            this.farmacia.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.farmacia.setImageResource(R.drawable.ic_falso);
        }
        if ((mantencion)) {
            this.mantencion.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.mantencion.setImageResource(R.drawable.ic_falso);
        }
        if ((autoservicio)) {
            this.autoservicio.setImageResource(R.drawable.ic_verdadero);
        } else {
            this.autoservicio.setImageResource(R.drawable.ic_falso);
        }

    }
}