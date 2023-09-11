package com.crudmarca.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Marcas", uniqueConstraints=@UniqueConstraint(columnNames={"marca_id", "marca_nombre"}))
@SQLDelete(sql = "UPDATE Marcas SET eliminado = true WHERE marca_id = ?")
@Where(clause = "eliminado = false")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marca_id;
    
    @Size(max = 100)
    @Column(name = "marca_nombre", unique = true,nullable = false)
    private String marca_nombre;

    private boolean eliminado =Boolean.FALSE;

    public Marca() {
        super();
    }
    
    
    @Override
    public String toString() {
        return "Marca [marca_id=" + marca_id + ", marca_nombre=" + marca_nombre + "]";
    }
    
    public Integer getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }
    
        public String getMarca_nombre() {
            return marca_nombre;
        }
        
    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }

    public boolean isEliminado() {
        return eliminado;
    }


    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

}
