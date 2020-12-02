package com.fuel.fullfuel.Interfaces;
import com.fuel.fullfuel.clases.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseAPI {

    @GET("estaciones?token=jlw1dcAJtD&region=[04]")
    public  Call<ResponseData> getGasolineras();
}
