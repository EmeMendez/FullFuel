package com.fuel.fullfuel.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MetodosDePago implements Serializable {

    private Boolean efectivo;
    private Boolean cheque;
    @SerializedName("tarjetas bancarias")
    @Expose
    private Boolean tarjetas_bancarias;
    @SerializedName("tarjetas grandes tiendas")
    @Expose
    private Boolean tarjetas_grandes_tiendas;

    public Boolean getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Boolean efectivo) {
        this.efectivo = efectivo;
    }

    public Boolean getCheque() {
        return cheque;
    }

    public void setCheque(Boolean cheque) {
        this.cheque = cheque;
    }

    public Boolean getTarjetas_bancarias() {
        return tarjetas_bancarias;
    }


    public void setTarjetas_bancarias(Boolean tarjetas_bancarias) {
        this.tarjetas_bancarias = tarjetas_bancarias;
    }

    public Boolean getTarjetas_grandes_tiendas() {
        return tarjetas_grandes_tiendas;
    }

    public void setTarjetas_grandes_tiendas(Boolean tarjetas_grandes_tiendas) {
        this.tarjetas_grandes_tiendas = tarjetas_grandes_tiendas;
    }
}
