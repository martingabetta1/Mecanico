package com.crudmarca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudmarca.model.Modelo;
import com.crudmarca.model.Marca;

import com.crudmarca.repository.MarcaRepository;
import com.crudmarca.repository.ModeloRepository;

@Controller
@RequestMapping("/modelos")  // http://localhost:8080/modelos
public class ModeloController {


    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping("")
    public String home(Model model){
        List<Modelo> modelosActivos = modeloRepository.findByEliminadoFalse();
        model.addAttribute("Modelos", modelosActivos);
        return "modelo/home";
    }


    @GetMapping("/create") // http://localhost:8080/modelos/create
    public String create(Model model){
        List<Marca> marcas = marcaRepository.findAll();
        model.addAttribute("Marcas", marcas);
        return "modelo/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Modelo modelo, @RequestParam("marca_id") Integer marca_id){
        Marca marcaSeleccionada = marcaRepository.findById(marca_id).orElse(null);
        modelo.setModelo_marca(marcaSeleccionada);
        modeloRepository.save(modelo);
        return "redirect:/modelos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Modelo modelo = modeloRepository.getReferenceById(id);
        List<Marca> marcas = marcaRepository.findAll();
        model.addAttribute("Marcas", marcas);
        model.addAttribute("modelo", modelo);
        return "/modelo/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Modelo modelo = modeloRepository.getReferenceById(id);
        modeloRepository.delete(modelo);
        return "redirect:/modelos";
    }
}
