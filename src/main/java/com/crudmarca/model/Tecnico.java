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
@Table(name="Tecnico", uniqueConstraints=@UniqueConstraint(columnNames={"tecnico_id", "tecnico_nombre"}))

public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tecnico_id;
    
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "tecnico_nombre", unique = true,nullable = false)
    private String tecnico_nombre;


    @Column(name = "fecha_creacion", updatable= false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;  

    @Column(name = "fecha_modificacion") 
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;

    
    public Tecnico(@NotNull @NotBlank @Size(max = 100) String tecnico_nombre) {
        this.tecnico_nombre = tecnico_nombre;
    }

    public Tecnico(){
        super();
    }

    @Override
    public String toString() {
        return "Tecnico [tecnico_id=" + tecnico_id + ", tecnico_nombre=" + tecnico_nombre + ", fechaCreacion="
                + fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
    }

    public Integer getTecnico_id() {
        return tecnico_id;
    }

    public void setTecnico_id(Integer tecnico_id) {
        this.tecnico_id = tecnico_id;
    }

    public String getTecnico_nombre() {
        return tecnico_nombre;
    }

    public void setTecnico_nombre(String tecnico_nombre) {
        this.tecnico_nombre = tecnico_nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }


    

}
