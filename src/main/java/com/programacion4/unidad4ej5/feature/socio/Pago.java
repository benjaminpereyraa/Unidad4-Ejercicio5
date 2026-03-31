package com.programacion4.unidad4ej5.feature.socio;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "1000.00", message = "El monto no puede ser menor a 1000.00")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener hasta 2 decimales")
    private BigDecimal monto;

    @Pattern(regexp = "PAY-[A-Z0-9]{4}-[A-Z0-9]{4}", message = "El código de transacción debe seguir el patrón PAY-XXXX-XXXX")
    @NotBlank(message = "El código de transacción no puede estar vacío")
    private String codigoTransaccion;

    @Future(message = "La fecha de vencimiento debe ser una fecha en el futuro")
    private LocalDate fechaVencimiento;

    @NotNull(message = "El tipo de pago no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public enum TipoPago {
        EFECTIVO, DEBITO, CREDITO, TRANSFERENCIA
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public String getCodigoTransaccion() { return codigoTransaccion; }
    public void setCodigoTransaccion(String codigoTransaccion) { this.codigoTransaccion = codigoTransaccion; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public TipoPago getTipoPago() { return tipoPago; }
    public void setTipoPago(TipoPago tipoPago) { this.tipoPago = tipoPago; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
}