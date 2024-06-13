package com.techforb.backend.service;

import com.techforb.backend.model.Planta;
import com.techforb.backend.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    public List<Planta> obtenerTodasLasPlantas() {
        return plantaRepository.findAll();
    }

    public Planta obtenerPlantaPorId(Long id) {
        Optional<Planta> optionalPlanta = plantaRepository.findById(id);
        return optionalPlanta.orElse(null);
    }

    public Planta crearPlanta(Planta planta) {
        return plantaRepository.save(planta);
    }

    public Planta actualizarPlanta(Long id, Planta planta) {
        if (plantaRepository.existsById(id)) {
            planta.setId(id);
            return plantaRepository.save(planta);
        }
        return null;
    }

    public void eliminarPlanta(Long id) {
        plantaRepository.deleteById(id);
    }
}
