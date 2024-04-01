package com.example.appcomida.modelo;

import org.springframework.data.annotation.Id;

public class menuModelo {

    @Id
    private int codigo;
    private String nombre_producto;
    private String tipo_producto;
    private String precio_producto;

    


    public menuModelo() {
    }


    public menuModelo(int codigo, String nombre_producto, String tipo_producto, String precio_producto) {
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
        this.tipo_producto = tipo_producto;
        this.precio_producto = precio_producto;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNombre_producto() {
        return nombre_producto;
    }


    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }


    public String getTipo_producto() {
        return tipo_producto;
    }


    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }


    public String getPrecio_producto() {
        return precio_producto;
    }


    public void setPrecio_producto(String precio_producto) {
        this.precio_producto = precio_producto;
    }


    


    

}
