package com.ejemplosemestral.gestor_usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplosemestral.gestor_usuario.model.Usuario;

@Service
public class UserService {

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

   public String crearUsuario(Usuario usuario){
    usuarios.add(usuario);
    return "Usuario creado exitosamente !!!! ";

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
