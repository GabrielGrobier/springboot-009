package com.ejemplosemestral.gestor_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplosemestral.gestor_usuario.model.Usuario;
import com.ejemplosemestral.gestor_usuario.model.dto.UsuarioDto;
import com.ejemplosemestral.gestor_usuario.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userservice1;

    UserService accionesUsuario = new UserService();

    @GetMapping("/usuarios")
    public List<Usuario> mostrarUsuarios(){
        return accionesUsuario.getAllUser();
        
    }

    @GetMapping("/usuarios/{correo}")
    public ResponseEntity<UsuarioDto> obtenerUsuario(@PathVariable String correo){
        if (userservice1.obtenerUsuario(correo) != null){
            return  ResponseEntity.ok(userservice1.obtenerUsuarioDto(correo));
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(userservice1.crearUsuario(usuario));

    }

    @DeleteMapping("/usuarios/{id}")
    public String borrarUsuario(@PathVariable int id){
        return accionesUsuario.borrarUsuario(id);

    }

    //@PutMapping()

}
