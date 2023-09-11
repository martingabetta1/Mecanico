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

import com.crudmarca.model.Cliente;
import com.crudmarca.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")  // http://localhost:8080/clientes
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("")
    public String home(Model model){
        List<Cliente> clientesActivos = clienteRepository.findByEliminadoFalse();
        model.addAttribute("Clientes", clientesActivos);
        return "cliente/home";
    }


    @GetMapping("/create") // http://localhost:8080/clientes/create
    public String create(){
        return "cliente/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cliente cliente){
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Cliente cliente = clienteRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Cliente cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);
        return "redirect:/clientes";
    }
}

