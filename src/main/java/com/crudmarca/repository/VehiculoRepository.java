package com.crudmarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.crudmarca.model.Vehiculo;

//@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {
    
}
