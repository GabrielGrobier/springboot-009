package com.ejemplosemestral.gestor_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplosemestral.gestor_usuario.model.entity.UsuarioEntity;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    UsuarioEntity findByCorreo(String correo);
    Boolean existsByCorreo(String correo);
    void deleteById(int id);
    Boolean findByCorreoAndPassword(String correo , String password);
    UsuarioEntity findUsuarioById(int id);

    
}
