package com.programacion4.unidad4ej5.feature.socio;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Email(message = "El email debe tener un formato válido")
    @NotBlank(message = "El email no puede estar vacío")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener exactamente 8 dígitos")
    @NotBlank(message = "El DNI no puede estar vacío")
    @Column(unique = true)
    private String dni;

    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    @Adulto
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "\\+\\d{1,3}\\d{1,14}", message = "El teléfono debe seguir el formato internacional (ej: +549...)")
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @URL(message = "La URL de la foto debe ser válida")
    private String urlFoto;

    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @Pattern(regexp = "\\S+", message = "El alias no puede contener espacios")
    private String alias;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}