package com.example.appcomida.controlador;

import java.util.ArrayList;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appcomida.modelo.clienteModelo;
import com.example.appcomida.servicio.clienteServicio;

@RestController
@RequestMapping(path="/clientes")
@CrossOrigin("*")
public class clienteControlador {
    

    @Autowired
    clienteServicio servicios;



    @GetMapping("/Login/{correo}")
   public ArrayList<clienteModelo> login (@PathVariable("correo") String correo){
     return servicios.SessionLogin(correo);

   }

    // @PostMapping("/login")
    // public String login(@RequestBody Map<String, String> data){
    //     try {
    //         String correo = data.get("correo");
    //         String contrasena = data.get("password");

    //         clienteModelo user = servicios.login(correo).get(1);

            
    //         if(correo!="" & contrasena !="")
    //             if (user != null && user.getPassword().equals(contrasena))
    //                 return "{\"success\": true, \"message\": \"Login correcto.\"}";
    //             else 
    //                 return "{\"success\": false, \"message\": \"Credenciales incorrectas.\"}";
    //         else   
    //             return "{\"success\": false, \"message\": \"Los campos de usuario y contraseña no pueden estar vacios.\"}"; 
    //     } catch (Exception e) {
    //         return "{\"success\": false, \"message\": \"Error de comunicación con el servidor.\"}";
    //     }
    // }


    @PostMapping(path="/guardar")
    public String guardarUsuario(@RequestBody clienteModelo usuario) {
        try {

            if (usuario != null) {
                Boolean respuesta = servicios.guardarUsuario(usuario);

                if (respuesta)
                    return "{\"success\": true, \"message\": \"Usuario almacenado correctamente.\"}";
                else
                    return "{\"success\": false, \"message\": \"No se pudo almacenar el usuario, revisa los parametros.\"}";
            } else
                return "{\"success\": false, \"message\": \"No se puede almacenar un usuario vacio.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }





}
