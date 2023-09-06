package com.example.crudangular.service.impl;

import com.example.crudangular.model.Pais;
import com.example.crudangular.repository.IPaisRepository;
import com.example.crudangular.service.IPaisService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    IPaisRepository repo;

    @Override
    public List<Pais> listar() {
        return repo.findAll();
    }

    @Override
    public Pais registrar(Pais pais) {
        return repo.save(pais);
    }

    @Override
    public Pais actualizar(Pais pais) {
        return repo.save(pais);
    }

    @Override
    public void eliminar(Integer codigo) {
        repo.deleteById(codigo);
    }

    @Override
    public Pais listarPorId(Integer codigo) {
        return repo.findById(codigo).orElse(null);
    }
}
