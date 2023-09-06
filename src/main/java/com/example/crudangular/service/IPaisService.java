package com.example.crudangular.service;

import com.example.crudangular.model.Pais;

import java.util.List;

public interface IPaisService {

    List<Pais> listar();
    Pais registrar(Pais pais);
    Pais actualizar(Pais pais);
    void eliminar(Integer codigo);
    Pais listarPorId(Integer codigo);
}
