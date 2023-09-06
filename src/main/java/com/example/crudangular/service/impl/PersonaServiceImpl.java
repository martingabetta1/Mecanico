package com.example.crudangular.service.impl;

import com.example.crudangular.model.Persona;
import com.example.crudangular.repository.IPersonaRepository;
import com.example.crudangular.service.IPersonaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    IPersonaRepository repo;

    @Override
    public List<Persona> listar() {
        return repo.findAll();
    }

    @Override
    public Persona registrar(Persona persona) {
        return repo.save(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        return repo.save(persona);
    }

    @Override
    public void eliminar(Integer codigo) {
        repo.deleteById(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona listarPorId(Integer codigo) {
        return repo.findById(codigo).orElse(null);
    }

    @Override
    public Page<Persona> listPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
