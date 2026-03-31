package com.programacion4.unidad4ej5.feature.socio.dtos.response;

import java.time.LocalDate;

public class SocioResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String urlFoto;
    private String alias;

    // Constructor
    public SocioResponseDTO(Long id, String nombre, String apellido, String email, String dni, LocalDate fechaNacimiento, String telefono, String urlFoto, String alias) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.urlFoto = urlFoto;
        this.alias = alias;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getDni() { return dni; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getTelefono() { return telefono; }
    public String getUrlFoto() { return urlFoto; }
    public String getAlias() { return alias; }
}