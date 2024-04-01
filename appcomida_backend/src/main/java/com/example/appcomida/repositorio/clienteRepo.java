package com.example.appcomida.repositorio;

import java.util.ArrayList;
// import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.appcomida.modelo.clienteModelo;


@Repository
public interface clienteRepo extends MongoRepository<clienteModelo, Integer> {
    
    public ArrayList<clienteModelo>findByCorreo(String correo);
}
