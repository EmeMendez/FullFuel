package com.fuel.fullfuel.Interfaces;
import com.fuel.fullfuel.clases.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GasolineraAPI {

    @GET("estaciones?token=jlw1dcAJtD&region=[04]")
    public

        Call<ResponseData> index( @Query(value="gasolina 93", encoded = true) String gasolina_93,
                                  @Query("language") String language);
    ;
}
