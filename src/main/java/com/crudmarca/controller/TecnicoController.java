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

import com.crudmarca.model.Tecnico;
import com.crudmarca.repository.TecnicoRepository;

@Controller
@RequestMapping("/tecnicos")  // http://localhost:8080/tecnicos
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;


    @GetMapping("")
    public String home(Model model){
        List<Tecnico> tecnicosActivos = tecnicoRepository.findByEliminadoFalse();
        model.addAttribute("Tecnicos", tecnicosActivos);
        return "tecnico/home";
    }


    @GetMapping("/create") // http://localhost:8080/tecnicos/create
    public String create(){
        return "tecnico/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Tecnico tecnico){
        tecnicoRepository.save(tecnico);
        return "redirect:/tecnicos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Tecnico tecnico = tecnicoRepository.getReferenceById(id);
        model.addAttribute("tecnico", tecnico);
        return "tecnico/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Tecnico tecnico = tecnicoRepository.getReferenceById(id);
        tecnicoRepository.delete(tecnico);
        return "redirect:/tecnicos";
    }
}
