package com.fuel.fullfuel.clases;

public class Comunas {
      public String cod_region;
      public String nom_region;
      public String cod_comuna;
      public String nom_comuna;

    public String getCod_region() {
        return cod_region;
    }

    public void setCod_region(String cod_region) {
        this.cod_region = cod_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public String getCod_comuna() {
        return cod_comuna;
    }

    public void setCod_comuna(String cod_comuna) {
        this.cod_comuna = cod_comuna;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    @Override
    public String toString() {
        return nom_comuna;
    }
}
