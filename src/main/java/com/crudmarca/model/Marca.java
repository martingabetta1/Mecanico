package com.crudmarca.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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


    @Column(name = "fecha_creacion", updatable= false)
    @CreationTimestamp
    private LocalDateTime fecha_creacion;  

    @Column(name = "fecha_modificacion") 
    @UpdateTimestamp
    private LocalDateTime fecha_modificacion;

    public String getMarca_nombre() {
        return marca_nombre;
    }
    
    public Marca() {
        super();
    }


    @Override
    public String toString() {
        return "Marca [marca_id=" + marca_id + ", marca_nombre=" + marca_nombre + ", fecha_creacion=" + fecha_creacion
                + ", fecha_modificacion=" + fecha_modificacion + "]";
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

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

}
