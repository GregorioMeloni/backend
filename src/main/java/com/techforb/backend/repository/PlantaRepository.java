package com.techforb.backend.repository;

import com.techforb.backend.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
    // Puedes agregar métodos personalizados de consulta si los necesitas
}
