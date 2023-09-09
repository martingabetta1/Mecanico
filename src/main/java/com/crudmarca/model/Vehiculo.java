package com.crudmarca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehiculo_id;



    @NotNull
    @Pattern(
        regexp = "^[A-Z]{3} \\d{3}$|^[A-Z]{2} \\d{3} [A-Z]{2}$",
        message = "El formato de la patente no es válido."
    )
    @Column(name = "vehiculo_patente", nullable = false)
    private String vehiculo_patente;

    @ManyToOne
    @JoinColumn(name="modelo_id")
    private Modelo vehiculo_modelo;

    

    public Vehiculo() {
        super();
    }

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public String getVehiculo_patente() {
        return vehiculo_patente;
    }

    public void setVehiculo_patente(String vehiculo_patente) {
        this.vehiculo_patente = vehiculo_patente;
    }

    public Modelo getVehiculo_modelo() {
        return vehiculo_modelo;
    }

    public void setVehiculo_modelo(Modelo vehiculo_modelo) {
        this.vehiculo_modelo = vehiculo_modelo;
    }



}
