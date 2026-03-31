package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PlanCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@Service
@Validated
public class PlanEntrenamientoService {

    @Autowired
    private PlanEntrenamientoRepository planRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Transactional
    public PlanEntrenamiento crearPlan(@Valid PlanCreateDTO dto, Long socioId) {
        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new IllegalArgumentException("Socio no encontrado"));
        PlanEntrenamiento plan = new PlanEntrenamiento();
        plan.setObjetivo(dto.getObjetivo());
        plan.setFrecuenciaSemanal(dto.getFrecuenciaSemanal());
        plan.setPesoInicial(dto.getPesoInicial());
        plan.setAltura(dto.getAltura());
        plan.setEjercicios(dto.getEjercicios());
        plan.setSocio(socio);
        return planRepository.save(plan);
    }
}