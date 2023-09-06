package com.example.crudangular.controller;

import com.example.crudangular.model.Persona;
import com.example.crudangular.service.IPersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        List<Persona> obj = service.listar();
        return new ResponseEntity<List<Persona>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Persona> registrar(@RequestBody Persona persona) {
        Persona obj = service.registrar(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Persona> actualizar(@RequestBody Persona persona) {
        Persona obj = service.actualizar(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> eliminar(@PathVariable("id") Integer id) throws Exception{
        Persona obj = service.listarPorId(id);
        if(obj == null) {
            throw new Exception("No se encontro el ID");
        }

        service.eliminar(id);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Persona obj = service.listarPorId(id);
        if(obj == null) {
            throw new Exception("No se encontro el ID");

        }
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Persona>> listPageable(Pageable pageable) throws Exception{
        Page<Persona> persona = service.listPageable(pageable);
        return new ResponseEntity<Page<Persona>>(persona, HttpStatus.OK);
    }

}
