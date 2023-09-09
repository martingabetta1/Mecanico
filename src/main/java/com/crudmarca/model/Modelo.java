package com.crudmarca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelo_id;


    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(name = "modelo_nombre", nullable = false)
    private String modelo_nombre;

    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca modelo_marca;

    // Constructor
    public Modelo() {
        super();
    }
    
    // Getters y Setters
    public Integer getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Integer modelo_id) {
        this.modelo_id = modelo_id;
    }

    public String getModelo_nombre() {
        return modelo_nombre;
    }

    public void setModelo_nombre(String modelo_nombre) {
        this.modelo_nombre = modelo_nombre;
    }

    public Marca getModelo_marca() {
        return modelo_marca;
    }

    public void setModelo_marca(Marca modelo_marca) {
        this.modelo_marca = modelo_marca;
    }


    
    

}
