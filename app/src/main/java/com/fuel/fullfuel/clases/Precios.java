package com.fuel.fullfuel.clases;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Precios implements Serializable {

    @SerializedName("gasolina 93")
    @Expose
    private String gasolina_93;

    @SerializedName("gasolina 97")
    @Expose
    private String gasolina_97;

    @SerializedName("petroleo diesel")
    @Expose
    private String petroleo_diesel;

    @SerializedName("gasolina 95")
    @Expose
    private String gasolina_95;

    @SerializedName("glp vehicular")
    @Expose
    private String glp_vehicular;

    public String getGasolina_93() {
        return gasolina_93;
    }

    public void setGasolina_93(String gasolina_93) {
        this.gasolina_93 = gasolina_93;
    }

    public String getGasolina_97() {
        return gasolina_97;
    }
    public void setGasolina_97(String gasolina_97) {
        this.gasolina_97 = gasolina_97;
    }

    public String getPetroleo_diesel() {
        return petroleo_diesel;
    }

    public void setPetroleo_diesel(String petroleo_diesel) {
        this.petroleo_diesel = petroleo_diesel;
    }

    public String getGasolina_95() {
        return gasolina_95;
    }

    public void setGasolina_95(String gasolina_95) {
        this.gasolina_95 = gasolina_95;
    }

    public String getGlp_vehicular() {
        return glp_vehicular;
    }

    public void setGlp_vehicular(String glp_vehicular) {
        this.glp_vehicular = glp_vehicular;
    }
}
