package com.fuel.fullfuel.clases;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.fuel.fullfuel.R;

public class MostrarDialogo {
    Activity activity;
    AlertDialog dialog;


    public MostrarDialogo(Activity myActivity){
        this.activity = myActivity;
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
        dialog.show();

    }

    public void dismissDialog(){
        dialog.dismiss();
    }

}
