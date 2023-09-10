package com.crudmarca.crudmarca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String inicio() {
        return "index"; // Devuelve la vista de inicio del sistema
    }
}
