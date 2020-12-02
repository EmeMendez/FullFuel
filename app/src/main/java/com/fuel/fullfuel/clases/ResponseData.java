package com.fuel.fullfuel.clases;

import java.util.List;

public class ResponseData {
    private String estado;
    private String descripcion;
    private List<Gasolinera> data;

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
}
