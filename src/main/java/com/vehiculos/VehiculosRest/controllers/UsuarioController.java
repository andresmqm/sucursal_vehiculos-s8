package com.vehiculos.VehiculosRest.controllers;

import com.vehiculos.VehiculosRest.models.Usuario;
import com.vehiculos.VehiculosRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // Por si necesitas consumirla desde el frontend sin problemas de CORS
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}