package com.example.appcomida.controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appcomida.modelo.menuModelo;
import com.example.appcomida.servicio.menuServicio;
// import com.google.gson.Gson;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")

public class menuControlador {

    @Autowired
    menuServicio servicios;

    @GetMapping(path = "/ver")
    public ArrayList<menuModelo> Verproductos() {
        return servicios.consultarMenus();
    }

    @GetMapping(path = "/verid/{codigo}")
    public Optional<menuModelo> VerMenuId(@PathVariable("codigo") Integer codigo) {
        return servicios.ConsultarMenusID(codigo);
    }
    // @GetMapping("/ver")
    // public ArrayList<menuModelo> obtenerMenus() {
    // try {
    // ArrayList<menuModelo> Menus = servicios.consultarMenus();

    // // // Gson json = new Gson();

    // // if (Menus == null)
    // // return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la
    // consulta.\"}";
    // // else if (Menus.size() == 0)
    // // return "{\"success\": false, \"message\": \"No hay Menus que mostrar.\"}";
    // // else {

    // // return "{\"success\": true, \"message\": \"Consulta realizada
    // correctamente.\", \"data\": "
    // // + json.toJson(Menus)
    // // + "}";
    // // }

    // } catch (Exception e) {
    // System.out.println(e);
    // // return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la
    // consulta.\"}";
    // }

    // }

    @PostMapping(value = "/guardar")
    public String guardarMenu(@RequestBody menuModelo Menu) {
        try {

            if (Menu != null) {
                Boolean respuesta = servicios.guardarMenu(Menu);

                if (respuesta)
                    return "{\"success\": true, \"message\": \"Menu almacenado correctamente.\"}";
                else
                    return "{\"success\": false, \"message\": \"No se pudo almacenar el Menu, revisa los parametros.\"}";
            } else
                return "{\"success\": false, \"message\": \"No se puede almacenar un Menu vacio.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @PostMapping(value = "/actualizar")
    public String actualizarMenu(@RequestBody menuModelo user) {
        try {
            boolean response = servicios.actualizarMenu(user);

            if (response)
                return "{\"success\": true, \"message\": \"Menu actualizado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo actualizar el Menu, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarMenu(@PathVariable Integer id) {
        try {
            boolean response = servicios.eliminarMenu(id);
            if (response)
                return "{\"success\": true, \"message\": \" eliminado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo eliminar el Menu, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

}
