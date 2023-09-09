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

import com.crudmarca.model.Marca;
import com.crudmarca.repository.MarcaRepository;

@Controller
@RequestMapping("/marcas")  // http://localhost:8080/marcas
public class MarcaController {


    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping("")
    public String home(Model model) {
        List<Marca> marcasActivas = marcaRepository.findByEliminadoFalse();
        model.addAttribute("Marcas", marcasActivas);
        return "marca/home";
    }
    


    @GetMapping("/create") // http://localhost:8080/marcas/create
    public String create(){
        return "marca/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Marca marca){
        marcaRepository.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Marca marca = marcaRepository.getReferenceById(id);
        model.addAttribute("marca", marca);
        return "/marca/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Marca marca = marcaRepository.getReferenceById(id);
        marcaRepository.delete(marca);
        return "redirect:/marcas";
    }
}
