package com.programacion4.unidad4ej5.feature.socio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    boolean existsByEmail(String email);
    boolean existsByDni(String dni);
}