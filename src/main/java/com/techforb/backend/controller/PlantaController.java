package com.techforb.backend.controller;

import com.techforb.backend.model.Planta;
import com.techforb.backend.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantas")
public class PlantaController {

    @Autowired
    private PlantaService plantaService;

    // Endpoint para obtener todas las plantas
    @GetMapping
    public ResponseEntity<List<Planta>> obtenerTodasLasPlantas() {
        List<Planta> plantas = plantaService.obtenerTodasLasPlantas();
        return new ResponseEntity<>(plantas, HttpStatus.OK);
    }

    // Endpoint para obtener una planta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Planta> obtenerPlantaPorId(@PathVariable Long id) {
        Planta planta = plantaService.obtenerPlantaPorId(id);
        return new ResponseEntity<>(planta, HttpStatus.OK);
    }

    // Endpoint para crear una nueva planta
    @PostMapping
    public ResponseEntity<Planta> crearPlanta(@RequestBody Planta planta) {
        Planta nuevaPlanta = plantaService.crearPlanta(planta);
        return new ResponseEntity<>(nuevaPlanta, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una planta existente
    @PutMapping("/{id}")
    public ResponseEntity<Planta> actualizarPlanta(@PathVariable Long id, @RequestBody Planta planta) {
        Planta plantaActualizada = plantaService.actualizarPlanta(id, planta);
        return new ResponseEntity<>(plantaActualizada, HttpStatus.OK);
    }

    // Endpoint para eliminar una planta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPlanta(@PathVariable Long id) {
        plantaService.eliminarPlanta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
