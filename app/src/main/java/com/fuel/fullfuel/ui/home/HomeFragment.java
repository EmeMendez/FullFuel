package com.fuel.fullfuel.ui.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuel.fullfuel.Interfaces.ResponseAPI;
import com.fuel.fullfuel.R;
import com.fuel.fullfuel.adaptadores.GasolineraAdaptador;
import com.fuel.fullfuel.clases.Comunas;
import com.fuel.fullfuel.clases.Distribuidor;
import com.fuel.fullfuel.clases.Gasolinera;
import com.fuel.fullfuel.clases.MostrarDialogo;
import com.fuel.fullfuel.clases.Precios;
import com.fuel.fullfuel.clases.ResponseData;
import com.fuel.fullfuel.clases.ResponseDataComuna;
import com.fuel.fullfuel.clases.Ubicacion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView show_filter_dialog;
    public static ArrayList<Gasolinera> gasolineras_filtradas;
    public static ArrayList<Comunas> comunas;
    public Spinner spinner_comunas;

    AlertDialog dialog;


    private HomeViewModel homeViewModel;
    private TextView razon_social;
    public static ArrayList<Gasolinera> gasolineras;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        show_filter_dialog = (TextView) view.findViewById(R.id.show_filter_dialog);
        spinner_comunas = view.findViewById(R.id.spinner_comuna);



        show_filter_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarDialogo loadingDialog = new MostrarDialogo(getActivity());

                loadingDialog.startLoadingDialog("avisos");

            }
        });

        //final TextView textView = view.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        getGasolineras();
        return view;
    }





    private void getGasolineras(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.cne.cl/v3/combustibles/vehicular/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //llamar a la interfaz
        ResponseAPI responseAPI = retrofit.create(ResponseAPI.class);
        Call<ResponseData> call = responseAPI.getGasolineras();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if(!response.isSuccessful()){
                    razon_social.setText("código " + response.code());
                    return;
                }
                ResponseData responseData = response.body();
                gasolineras = new ArrayList();

                for(Gasolinera gasolinera: responseData.getData()){
                    //gasolineras.add(gasolinera);
                    gasolineras.add(gasolinera);
                }

                LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
                GasolineraAdaptador gasolineraAdaptador;
                gasolineraAdaptador = new GasolineraAdaptador(getContext(),gasolineras);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(gasolineraAdaptador);
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });

    }










}