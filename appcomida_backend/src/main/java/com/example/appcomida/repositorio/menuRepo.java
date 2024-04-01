package com.example.appcomida.repositorio;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.appcomida.modelo.menuModelo;


@Repository
public interface menuRepo extends MongoRepository<menuModelo, Integer> {

    public Optional<menuModelo>findById(Integer codigo);
    
}
