package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PagoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/socios/{socioId}")
    public ResponseEntity<Pago> registrarPago(@Valid @RequestBody PagoRequestDTO dto, @PathVariable Long socioId) {
        Pago pago = pagoService.registrarPago(dto, socioId);
        return ResponseEntity.ok(pago);
    }
}