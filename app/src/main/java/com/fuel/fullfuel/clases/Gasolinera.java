package com.fuel.fullfuel.clases;

public class Gasolinera {
    private String id;
    private String fecha_hora_actualizacion;
    private String razon_social;
    private String direccion_calle;
    private String direccion_numero;
    private String id_comuna;
    private String nombre_comuna;
    private String id_region;
    private String nombre_region;
    private String horario_atencion;
    private Distribuidor distribuidor;
    private Precios precios;
    private Ubicacion ubicacion;
    private MetodosDePago metodos_de_pago;
    private Servicios servicios;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha_hora_actualizacion() {
        return fecha_hora_actualizacion;
    }

    public void setFecha_hora_actualizacion(String fecha_hora_actualizacion) {
        this.fecha_hora_actualizacion = fecha_hora_actualizacion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion_calle() {
        return direccion_calle;
    }

    public void setDireccion_calle(String direccion_calle) {
        this.direccion_calle = direccion_calle;
    }

    public String getDireccion_numero() {
        return direccion_numero;
    }

    public void setDireccion_numero(String direccion_numero) {
        this.direccion_numero = direccion_numero;
    }

    public String getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(String id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre_comuna() {
        return nombre_comuna;
    }

    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }

    public String getId_region() {
        return id_region;
    }

    public void setId_region(String id_region) {
        this.id_region = id_region;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    public String getHorario_atencion() {
        return horario_atencion;
    }

    public void setHorario_atencion(String horario_atencion) {
        this.horario_atencion = horario_atencion;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Precios getPrecios() {
        return precios;
    }

    public void setPrecios(Precios precios) {
        this.precios = precios;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public MetodosDePago getMetodos_de_pago() {
        return metodos_de_pago;
    }

    public void setMetodos_de_pago(MetodosDePago metodos_de_pago) {
        this.metodos_de_pago = metodos_de_pago;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
}
