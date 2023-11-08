package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
