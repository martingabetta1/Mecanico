package com.crudmarca.crudmarca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudmarca.crudmarca.model.Marca;
import com.crudmarca.crudmarca.repository.MarcaRepository;

@Controller
@RequestMapping("/marcas")  // http://localhost:8080/marcas
public class MarcaController {

    private final Logger logger = LoggerFactory.getLogger(Marca.class);

    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping("")
    public String home(Model model){
        model.addAttribute("Marcas", marcaRepository.findAll());
        return "home";
    }


    @GetMapping("/create") // http://localhost:8080/marcas/create
    public String create(){
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Marca marca){
        logger.info("Datos Marca, {}", marca);
        marcaRepository.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Marca marca = marcaRepository.getReferenceById(id);
        logger.info("Marca Obtenida, {}", marca);
        model.addAttribute("marca", marca);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Marca marca = marcaRepository.getReferenceById(id);
        logger.info("Marca Eliminada, {}", marca);
        marcaRepository.delete(marca);
        return "redirect:/marcas";
    }
}
