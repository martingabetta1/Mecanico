package com.crudmarca.crudmarca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Marcas", uniqueConstraints=@UniqueConstraint(columnNames={"marca_id", "marca_nombre"}))

public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marca_id;
    
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "marca_nombre", unique = true,nullable = false)
    private String marca_nombre;

    public String getMarca_nombre() {
        return marca_nombre;
    }
    
    public Marca() {
        super();
    }

    public Marca(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }


    @Override
    public String toString() {
        return "Marca [marca_id=" + marca_id + ", marca_nombre=" + marca_nombre;
    }

    public Integer getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }

    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    } 

}
