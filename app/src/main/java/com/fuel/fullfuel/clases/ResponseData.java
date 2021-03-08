package com.fuel.fullfuel.clases;

import java.util.List;

public class ResponseData {
    private String estado;
    private String descripcion;
    private List<Gasolinera> data;
    private List<Comunas> data_comunas;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Gasolinera> getData() {
        return data;
    }

    public void setData(List<Gasolinera> data) {
        this.data = data;
    }

    public List<Comunas> getData_comunas() {
        return data_comunas;
    }

    public void setData_comunas(List<Comunas> data_comunas) {
        this.data_comunas = data_comunas;
    }
}
