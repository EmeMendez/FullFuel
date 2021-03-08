package com.fuel.fullfuel.clases;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.fuel.fullfuel.Interfaces.ResponseAPI;
import com.fuel.fullfuel.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarDialogo {
    Activity activity;
    AlertDialog dialog;
    Spinner spinner_comunas;
    ArrayList<Comunas> comunas;


    public MostrarDialogo(Activity myActivity){

        this.activity = myActivity;
        this.spinner_comunas = (Spinner) activity.findViewById(R.id.spinner_comuna);

    }

    public void startLoadingDialog(String option){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        if(option.equals("avisos")) {
            builder.setView(inflater.inflate(R.layout.dialog_filtrar_ordenar, null));
        }else{
            builder.setView(inflater.inflate(R.layout.dialog_filtrar_ordenar, null));
        }builder.setCancelable(true);

        dialog = builder.create();
        getComunas();
        dialog.show();

    }

    public void dismissDialog(){
        dialog.dismiss();
    }



    private void getComunas(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.cne.cl/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //llamar a la interfaz
        ResponseAPI responseAPI = retrofit.create(ResponseAPI.class);
        Call<ResponseDataComuna> call = responseAPI.getComunas();
        call.enqueue(new Callback<ResponseDataComuna>() {

            @Override
            public void onResponse(Call<ResponseDataComuna> call, Response<ResponseDataComuna> response) {
                if(!response.isSuccessful()){

                    return;
                }
                ResponseDataComuna responseDataComuna = response.body();
                comunas = new ArrayList();
                Toast.makeText( activity, "success comunas", Toast.LENGTH_SHORT).show();

                for(Comunas comuna: responseDataComuna.getData()){
                    Toast.makeText( activity, comuna.getNom_comuna(), Toast.LENGTH_SHORT).show();

                    comunas.add(comuna);
                }



            }

            @Override
            public void onFailure(Call<ResponseDataComuna> call, Throwable t) {
                Toast.makeText( activity, "Fallo comunas + " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<Comunas> adapter = new ArrayAdapter<Comunas>(this.activity,
                android.R.layout.simple_spinner_dropdown_item,
                comunas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //this.spinner_comunas.setAdapter(new ArrayAdapter<Comunas>(this.dialog, android.R.layout.simple_spinner_dropdown_item, comunas));
        spinner_comunas.setAdapter(adapter);

    }

}
