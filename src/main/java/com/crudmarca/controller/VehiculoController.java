package com.crudmarca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudmarca.model.Modelo;
import com.crudmarca.model.Vehiculo;
import com.crudmarca.repository.ModeloRepository;
import com.crudmarca.repository.VehiculoRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/vehiculos") // http://localhost:8080/vehiculos
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping("")
    public String home(Model model) {
        List<Vehiculo> vehiculosActivos = vehiculoRepository.findByEliminadoFalse();
        List<Modelo> modelos = modeloRepository.findAll();
        model.addAttribute("Modelos", modelos);
        model.addAttribute("Vehiculos", vehiculosActivos);
        return "vehiculo/home";
    }

    @GetMapping("/create") // http://localhost:8080/vehiculo/create
    public String create(Model model) {
        List<Modelo> modelos = modeloRepository.findAll();
        model.addAttribute("Modelos", modelos);
        return "vehiculo/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Vehiculo vehiculo, @RequestParam("modelo_id") Integer modelo_id) {
        Modelo modeloSeleccionado = modeloRepository.findById(modelo_id).orElse(null);
        vehiculo.setVehiculo_modelo(modeloSeleccionado);
        vehiculoRepository.save(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        List<Modelo> modelos = modeloRepository.findAll();
        model.addAttribute("Modelos", modelos);
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(id);
        model.addAttribute("vehiculo", vehiculo);
        return "/vehiculo/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(id);
        vehiculoRepository.delete(vehiculo);
        return "redirect:/vehiculos";
    }
}
