package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PlanCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/planes")
public class PlanEntrenamientoController {

    @Autowired
    private PlanEntrenamientoService planService;

    @PostMapping("/socios/{socioId}")
    public ResponseEntity<PlanEntrenamiento> crearPlan(@Valid @RequestBody PlanCreateDTO dto, @PathVariable Long socioId) {
        PlanEntrenamiento plan = planService.crearPlan(dto, socioId);
        return ResponseEntity.ok(plan);
    }
}