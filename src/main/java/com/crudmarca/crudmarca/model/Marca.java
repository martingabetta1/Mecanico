package com.crudmarca.crudmarca.model;

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
    private LocalDateTime fechaCreacion;  

    @Column(name = "fecha_modificacion") 
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;

    public String getMarca_nombre() {
        return marca_nombre;
    }
    
    public Marca() {
        super();
    }

    public Marca(String marca_nombre) {
        this.marca_nombre = marca_nombre;
        this.fechaCreacion = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Marca [marca_id=" + marca_id + ", marca_nombre=" + marca_nombre + ", fechaCreacion=" + fechaCreacion
                + ", fechaModificacion=" + fechaModificacion + "]";
    }

    public Integer getMarca_id() {
        return marca_id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }

    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }    

}
