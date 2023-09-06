package com.example.crudangular.service;

import com.example.crudangular.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonaService {

    List<Persona> listar();
    Persona registrar(Persona persona);
    Persona actualizar(Persona persona);
    void eliminar(Integer codigo);
    Persona listarPorId(Integer codigo);

    Page<Persona> listPageable(Pageable pageable);

}
