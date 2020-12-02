package com.fuel.fullfuel.ui.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.fuel.fullfuel.clases.Distribuidor;
import com.fuel.fullfuel.clases.Gasolinera;
import com.fuel.fullfuel.clases.MostrarDialogo;
import com.fuel.fullfuel.clases.Precios;
import com.fuel.fullfuel.clases.ResponseData;
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


    AlertDialog dialog;


    private HomeViewModel homeViewModel;
    private TextView razon_social;
    public static ArrayList<Gasolinera> gasolineras;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //razon_social = view.findViewById(R.id.razon_social);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        show_filter_dialog = (TextView) view.findViewById(R.id.show_filter_dialog);



        show_filter_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog
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
                    /*
                    String content = "";
                    //                    content+= "id " + gasolinera.getId() + "\n";
                    //                    content+= "fecha_hora_actualizacion " + gasolinera.getId() + "\n";
                    //                    content+= "razon_social " + gasolinera.getRazon_social() + "\n";
                    //                    content+= "direccion_calle " + gasolinera.getDireccion_calle()+ "\n";
                    //                    content+= "direccion_numero " + gasolinera.getDireccion_numero() + "\n";
                    //                    content+= "id_comuna " + gasolinera.getId_comuna() + "\n";
                    //                    content+= "nombre_comuna " + gasolinera.getNombre_comuna() + "\n";
                    //                    content+= "id_region " + gasolinera.getId_region() + "\n";
                    //                    content+= "nombre_region " + gasolinera.getNombre_region() + "\n";
                    //                    content+= "horario_atencion " + gasolinera.getHorario_atencion() + "\n";
                    //
                    //                    content+= "---DISTRIBUIDOR---" + "\n";
                    //                    content+= "nombre " + gasolinera.getDistribuidor().getNombre() + "\n";
                    //                    content+= "logo " + gasolinera.getDistribuidor().getLogo() + "\n";
                    //                    content+= "logo_svg " + gasolinera.getDistribuidor().getLogo_svg() + "\n";
                    //                    content+= "logo_horizontal_svg " + gasolinera.getDistribuidor().getLogo_svg() + "\n";
                    //
                    //                    content+= "---PRECIOS---" + "\n";
                    //                    content+= "nglp vehicular " + gasolinera.getPrecios().getGlp_vehicular() + "\n";
                    //                    content+= "gasolina 93 " + gasolinera.getPrecios().getGasolina_93() + "\n";
                    //                    content+= "gasolina 95 " + gasolinera.getPrecios().getGasolina_95() + "\n";
                    //                    content+= "gasolina 97 " + gasolinera.getPrecios().getGasolina_97() + "\n";
                    //                    content+= "petroleo diesel " + gasolinera.getPrecios().getPetroleo_diesel() + "\n";
                    //
                    //
                    //                    content+= "---MÉTODOS DE PAGO---" + "\n";
                    //                    content+= "efectivo " + gasolinera.getMetodos_de_pago().getEfectivo() + "\n";
                    //                    content+= "cheque" + gasolinera.getMetodos_de_pago().getCheque() + "\n";
                    //                    content+= "tarjetas bancarias " + gasolinera.getMetodos_de_pago().getTarjetas_bancarias() + "\n";
                    //                    content+= "tarjetas grandes tiendas" + gasolinera.getMetodos_de_pago().getTarjetas_grandes_tiendas() + "\n";
                    //
                    //                    content+= "---UBICACIÓN---" + "\n";
                    //                    content+= "latitud " + gasolinera.getUbicacion().getLatitud() + "\n";
                    //                    content+= "longitud" + gasolinera.getUbicacion().getLongitud() + "\n";
                    //
                    //                    content+= "---SERVICIOS---" + "\n";
                    //                    content+= "tienda " + gasolinera.getServicios().getTienda() + "\n";
                    //                    content+= "farmacia" + gasolinera.getServicios().getMantencion() + "\n";
                    //                    content+= "mantencion" + gasolinera.getServicios().getMantencion() + "\n";
                    //                    content+= "autoservicio" + gasolinera.getServicios().getAutoservicio() + "\n";
                    //                    content+= "*********************" + gasolinera.getServicios().getAutoservicio() + "\n";
                    //                    content+= "    " + "\n";
                    //
                    //                    //razon_social.append(content);

                     */

                    //                    content+= "id " + gasolinera.getId() + "\n";
                    //                    content+= "fecha_hora_actualizacion " + gasolinera.getId() + "\n";
                    //                    content+= "razon_social " + gasolinera.getRazon_social() + "\n";
                    //                    content+= "direccion_calle " + gasolinera.getDireccion_calle()+ "\n";
                    //                    content+= "direccion_numero " + gasolinera.getDireccion_numero() + "\n";
                    //                    content+= "id_comuna " + gasolinera.getId_comuna() + "\n";
                    //                    content+= "nombre_comuna " + gasolinera.getNombre_comuna() + "\n";
                    //                    content+= "id_region " + gasolinera.getId_region() + "\n";
                    //                    content+= "nombre_region " + gasolinera.getNombre_region() + "\n";
                    //                    content+= "horario_atencion " + gasolinera.getHorario_atencion() + "\n";
                    //
                    //                    content+= "---DISTRIBUIDOR---" + "\n";
                    //                    content+= "nombre " + gasolinera.getDistribuidor().getNombre() + "\n";
                    //                    content+= "logo " + gasolinera.getDistribuidor().getLogo() + "\n";
                    //                    content+= "logo_svg " + gasolinera.getDistribuidor().getLogo_svg() + "\n";
                    //                    content+= "logo_horizontal_svg " + gasolinera.getDistribuidor().getLogo_svg() + "\n";
                    //
                    //                    content+= "---PRECIOS---" + "\n";
                    //                    content+= "nglp vehicular " + gasolinera.getPrecios().getGlp_vehicular() + "\n";
                    //                    content+= "gasolina 93 " + gasolinera.getPrecios().getGasolina_93() + "\n";
                    //                    content+= "gasolina 95 " + gasolinera.getPrecios().getGasolina_95() + "\n";
                    //                    content+= "gasolina 97 " + gasolinera.getPrecios().getGasolina_97() + "\n";
                    //                    content+= "petroleo diesel " + gasolinera.getPrecios().getPetroleo_diesel() + "\n";
                    //
                    //
                    //                    content+= "---MÉTODOS DE PAGO---" + "\n";
                    //                    content+= "efectivo " + gasolinera.getMetodos_de_pago().getEfectivo() + "\n";
                    //                    content+= "cheque" + gasolinera.getMetodos_de_pago().getCheque() + "\n";
                    //                    content+= "tarjetas bancarias " + gasolinera.getMetodos_de_pago().getTarjetas_bancarias() + "\n";
                    //                    content+= "tarjetas grandes tiendas" + gasolinera.getMetodos_de_pago().getTarjetas_grandes_tiendas() + "\n";
                    //
                    //                    content+= "---UBICACIÓN---" + "\n";
                    //                    content+= "latitud " + gasolinera.getUbicacion().getLatitud() + "\n";
                    //                    content+= "longitud" + gasolinera.getUbicacion().getLongitud() + "\n";
                    //
                    //                    content+= "---SERVICIOS---" + "\n";
                    //                    content+= "tienda " + gasolinera.getServicios().getTienda() + "\n";
                    //                    content+= "farmacia" + gasolinera.getServicios().getMantencion() + "\n";
                    //                    content+= "mantencion" + gasolinera.getServicios().getMantencion() + "\n";
                    //                    content+= "autoservicio" + gasolinera.getServicios().getAutoservicio() + "\n";
                    //                    content+= "*********************" + gasolinera.getServicios().getAutoservicio() + "\n";
                    //                    content+= "    " + "\n";

                }

                LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
                GasolineraAdaptador gasolineraAdaptador;
                gasolineraAdaptador = new GasolineraAdaptador(getContext(),gasolineras);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(gasolineraAdaptador);
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                //razon_social.setText("fallo " + t.getMessage());

            }
        });

    }





}