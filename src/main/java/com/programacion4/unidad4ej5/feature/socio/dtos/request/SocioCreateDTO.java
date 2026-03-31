package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import com.programacion4.unidad4ej5.feature.socio.Adulto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class SocioCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Email(message = "El email debe tener un formato válido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener exactamente 8 dígitos")
    @NotBlank(message = "El DNI no puede estar vacío")
    private String dni;

    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    @Adulto
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "\\+\\d{1,3}\\d{1,14}", message = "El teléfono debe seguir el formato internacional (ej: +549...)")
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}