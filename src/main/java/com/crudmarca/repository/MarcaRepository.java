package com.crudmarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.crudmarca.model.Marca;

//@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
    
}