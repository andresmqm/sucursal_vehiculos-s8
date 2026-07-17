package com.vehiculos.VehiculosRest.controllers;

import com.vehiculos.VehiculosRest.models.Usuario;
import com.vehiculos.VehiculosRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 1. GET - Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // 2. GET por ID - Buscar un usuario específico
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    // 3. POST - Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 4. PUT - Actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setFirstName(usuarioDetalles.getFirstName());
            usuario.setLastName(usuarioDetalles.getLastName());
            usuario.setEmail(usuarioDetalles.getEmail());
            return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
            usuarioDetalles.setId(id);
            return usuarioRepository.save(usuarioDetalles);
        });
    }

    // 5. DELETE - Eliminar un usuario
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Usuario eliminado correctamente con el ID: " + id;
        }
        return "El usuario con ID " + id + " no existe.";
    }
}