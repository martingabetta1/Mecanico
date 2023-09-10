package com.crudmarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.util.List;

import com.crudmarca.model.Modelo;

//@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer> {
    List<Modelo> findByEliminadoFalse();       
}