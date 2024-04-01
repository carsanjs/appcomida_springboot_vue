package com.example.appcomida.modelo;

import org.springframework.data.annotation.Id;



public class clienteModelo {

    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private String password;

    


    public clienteModelo() {
    }

    public clienteModelo(Integer id, String nombre, String apellido, String usuario, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getUsuario() {
        return usuario;
    }


    public String getCorreo() {
        return correo;
    }


    public String getPassword() {
        return password;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    
    
    
    
}
