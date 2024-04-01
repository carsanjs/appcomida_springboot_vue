package com.example.appcomida.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appcomida.modelo.clienteModelo;
import com.example.appcomida.repositorio.clienteRepo;

@Service
public class clienteServicio {

    @Autowired
    clienteRepo repositorio;


    public boolean guardarUsuario(clienteModelo usuario){

        try {
            clienteModelo respuesta = repositorio.save(usuario);
            if(respuesta != null)
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }


    public boolean actualizarUsuario(clienteModelo user){

        try {
            if(repositorio.existsById(user.getId())){
                repositorio.save(user);
                return true;
            }else return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<clienteModelo> consultarUsuarios(){
        try {
            return (ArrayList<clienteModelo>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }


    public Optional<clienteModelo> consultarUsuario(Integer id){

        try {
            if(!repositorio.existsById(id))return null;
            else return repositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }


    public boolean eliminarUsuario(Integer id){
        try {
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }


    public ArrayList<clienteModelo> SessionLogin (String correo){
        // try{
          ArrayList<clienteModelo> Login=repositorio.findByCorreo(correo);
            return Login;
        }

    // public ArrayList<clienteModelo> login(String correo){
    //     try{
    //         ArrayList<clienteModelo> usuario = repositorio.findByCorreo(correo);
    //         if (usuario.isEmpty())
    //             return null;
    //         else
    //             return usuario;

    //     }catch (Exception e){
    //         return null;
    //     }
    // }



    
}
