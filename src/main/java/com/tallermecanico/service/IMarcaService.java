package com.tallermecanico.service;

import com.tallermecanico.model.Marca;

import java.util.List;

public interface IMarcaService {

    List<Marca> listarMarcas();
    Marca registrar(Marca marca);

    Marca actualizar(Marca marca);

    void eliminar(Integer id);
}
