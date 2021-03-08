package com.fuel.fullfuel.clases;

import java.util.List;

public class ResponseDataComuna {
    private String estado;
    private String descripcion;
    private List<Comunas> data;

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

    public List<Comunas> getData() {
        return data;
    }

    public void setData(List<Comunas> data) {
        this.data = data;
    }


}
