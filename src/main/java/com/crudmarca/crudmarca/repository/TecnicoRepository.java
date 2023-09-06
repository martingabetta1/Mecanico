package com.crudmarca.crudmarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.crudmarca.crudmarca.model.Tecnico;

//@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
    
}

