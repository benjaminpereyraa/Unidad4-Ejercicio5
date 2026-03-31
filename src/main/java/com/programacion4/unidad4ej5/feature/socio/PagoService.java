package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PagoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import java.math.BigDecimal;

@Service
@Validated
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Transactional
    public Pago registrarPago(@Valid PagoRequestDTO dto, Long socioId) {
        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new IllegalArgumentException("Socio no encontrado"));
        Pago pago = new Pago();
        pago.setMonto(dto.getMonto());
        pago.setCodigoTransaccion(dto.getCodigoTransaccion());
        pago.setFechaVencimiento(dto.getFechaVencimiento());
        pago.setTipoPago(dto.getTipoPago());
        pago.setSocio(socio);
        return pagoRepository.save(pago);
    }
}