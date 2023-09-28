package com.tallermecanico.service.implementacion;

import com.tallermecanico.model.Marca;
import com.tallermecanico.repository.IMarcaRepository;
import com.tallermecanico.service.IMarcaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    IMarcaRepository repoMarca;

    @Override
    public List<Marca> listarMarcas() {
        return repoMarca.findByEliminadoFalse();
    }

    @Override
    public Marca registrar(Marca marca) {
        return repoMarca.save(marca);
    }

    @Override
    public Marca actualizar(Marca marca) {
        return repoMarca.save(marca);
    }

    public void eliminar(Integer marcaId) {
       repoMarca.eliminar(marcaId);
    }

}
