package com.ejemplosemestral.gestor_usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplosemestral.gestor_usuario.model.Usuario;
import com.ejemplosemestral.gestor_usuario.model.entity.UsuarioEntity;
import com.ejemplosemestral.gestor_usuario.repository.UsuarioRepository;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final List<Usuario> usuarios = new ArrayList<>();

    public UserService(){
        usuarios.add(new Usuario(1, "juanito", "juanito@gmail.com","1234" ));

    }
   public List<Usuario> getAllUser(){
        return usuarios;
   } 


   public Usuario obtenerUsuario(int id){
        for(Usuario user : usuarios){
            if(user.getId() == id){
                return user;
            }
        }
        return null;

   }

   //public String crearUsuario(Usuario usuario){
    //usuarios.add(usuario);
    //return "Usuario creado exitosamente !!!! ";

   //}
   public String crearUsuario(Usuario user){
        try{
            Boolean estado = usuarioRepository.existsByCorreo(user.getCorreo());
            if(estado != true){
                UsuarioEntity usuarioNuevo = new UsuarioEntity();
                usuarioNuevo.setId(user.getId());
                usuarioNuevo.setNombre(user.getNombre());
                usuarioNuevo.setCorreo(user.getCorreo());
                usuarioNuevo.setPassword(user.getPassword());
                usuarioRepository.save(usuarioNuevo);
                return "Usuario Creado con exito ";


            }
            return "El usuario ya existe ";
        }
        catch(Exception e){
            return " ocurrio un error al guardar el usuario ";
        }

   }

   public String borrarUsuario(int id){
    for (Usuario user : usuarios){
        if(user.getId() == id){
            usuarios.remove(user);
            return "usuario eliminado";
        }
    }
    return null;
   }

}
