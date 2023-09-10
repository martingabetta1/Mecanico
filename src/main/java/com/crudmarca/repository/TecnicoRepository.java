package com.crudmarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.util.List;

import com.crudmarca.model.Tecnico;

//@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
    List<Tecnico> findByEliminadoFalse();   
}

