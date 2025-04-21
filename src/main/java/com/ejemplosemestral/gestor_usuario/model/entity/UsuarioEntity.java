package com.ejemplosemestral.gestor_usuario.model.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //declarar una columna 
    @Column(name="nombre")
    private String nombre;
    //declarar una columna 
    private String correo;
    private String password;

    
}
