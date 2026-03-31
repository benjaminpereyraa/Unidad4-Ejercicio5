package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/socios")
@Validated
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public ResponseEntity<SocioResponseDTO> crearSocio(@Valid @RequestBody SocioCreateDTO dto) {
        SocioResponseDTO response = socioService.crearSocio(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> actualizarSocio(@PathVariable Long id, @Validated(ValidationGroups.Update.class) @RequestBody SocioUpdateDTO dto) {
        dto.setId(id);
        SocioResponseDTO response = socioService.actualizarSocio(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SocioResponseDTO>> listarSocios() {
        List<SocioResponseDTO> response = socioService.listarSocios();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> obtenerSocio(@PathVariable Long id) {
        return socioService.obtenerSocio(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}