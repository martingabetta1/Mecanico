package com.crudmarca.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

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
@Table(name="Cliente", uniqueConstraints=@UniqueConstraint(columnNames={"cliente_id", "cliente_nombre", "cliente_apellido", "cliente_telefono"}))
@SQLDelete(sql = "UPDATE Cliente SET eliminado = true WHERE cliente_id = ?")
@Where(clause = "eliminado = false")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cliente_id;
    
    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(name = "cliente_nombre",nullable = false)
    private String cliente_nombre;

    @Column(name = "cliente_apellido",nullable = false)
    private String cliente_apellido;

    @Column(name = "cliente_telefono", unique = true,nullable = false)
    private String cliente_telefono;

    @Column(name = "fecha_creacion", updatable= false)
    @CreationTimestamp
    private LocalDateTime fecha_creacion;  

    @Column(name = "fecha_modificacion") 
    @UpdateTimestamp
    private LocalDateTime fecha_modificacion;

    private boolean eliminado =Boolean.FALSE;

    public Cliente(){
        super();
    }
    

    public String getCliente_nombre() {
        return cliente_nombre;
    }


    public void setCliente_nombre(String cliente_nombre) {
        this.cliente_nombre = cliente_nombre;
    }


    public String getCliente_apellido() {
        return cliente_apellido;
    }


    public void setCliente_apellido(String cliente_apellido) {
        this.cliente_apellido = cliente_apellido;
    }


    public String getCliente_telefono() {
        return cliente_telefono;
    }


    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
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


    @Override
    public String toString() {
        return "Cliente [tecnico_id=" + cliente_id + ", cliente_nombre=" + cliente_nombre + ", cliente_apellido="
                + cliente_apellido + ", cliente_telefono=" + cliente_telefono + ", fecha_creacion=" + fecha_creacion
                + ", fecha_modificacion=" + fecha_modificacion + "]";
    }


    public Integer getCliente_id() {
        return cliente_id;
    }


    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }


    public boolean isEliminado() {
        return eliminado;
    }


    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }


}
