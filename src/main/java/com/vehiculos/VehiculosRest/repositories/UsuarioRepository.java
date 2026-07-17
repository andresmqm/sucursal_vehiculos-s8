package com.vehiculos.VehiculosRest.repositories;

import com.vehiculos.VehiculosRest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}