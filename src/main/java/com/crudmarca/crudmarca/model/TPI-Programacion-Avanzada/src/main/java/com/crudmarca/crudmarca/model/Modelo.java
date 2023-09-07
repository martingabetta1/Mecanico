package com.crudmarca.crudmarca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Modelos", uniqueConstraints = @UniqueConstraint(columnNames = {"modelo_id", "modelo_nombre"}))

/**
 * Modelo
 */


public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelo_id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "modelo_nombre", unique = true,nullable = false)
    private String modelo_nombre;

    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public void setModelo_id(Integer modelo_id){
        this.modelo_id = modelo_id;
    }

    public void setModelo_nombre(String modelo_nombre) {
        this.modelo_nombre = modelo_nombre;
    }

    public String getModelo_nombre() {
        return modelo_nombre;
    }


}
