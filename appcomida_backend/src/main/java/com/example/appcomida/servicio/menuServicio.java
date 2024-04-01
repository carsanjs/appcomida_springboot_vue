package com.example.appcomida.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appcomida.modelo.menuModelo;
import com.example.appcomida.repositorio.menuRepo;

@Service
public class menuServicio {

    @Autowired

    menuRepo repositorio;


    public ArrayList<menuModelo> consultarMenus(){
        try {
            return (ArrayList<menuModelo>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<menuModelo> ConsultarMenusID(Integer codigo){
        return repositorio.findById(codigo);
    }

    public boolean eliminarMenu(Integer id){
        try {
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean guardarMenu(menuModelo usuario){

        try {
            menuModelo respuesta = repositorio.save(usuario);
            if(respuesta != null)
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarMenu(menuModelo user){

        try {
            if(repositorio.existsById(user.getCodigo())){
                repositorio.save(user);
                return true;
            }else return false;
            
        } catch (Exception e) {
            return false;
        }
    }
    
}
