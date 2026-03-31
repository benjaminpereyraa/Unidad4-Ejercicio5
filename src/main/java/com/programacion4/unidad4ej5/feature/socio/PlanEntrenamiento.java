package com.programacion4.unidad4ej5.feature.socio;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "planes_entrenamiento")
public class PlanEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 10, max = 200, message = "El objetivo debe tener entre 10 y 200 caracteres")
    @NotBlank(message = "El objetivo no puede estar vacío")
    private String objetivo;

    @Min(value = 1, message = "La frecuencia semanal debe ser al menos 1")
    @Max(value = 7, message = "La frecuencia semanal no puede ser mayor a 7")
    private Integer frecuenciaSemanal;

    @DecimalMin(value = "30.0", message = "El peso inicial debe ser al menos 30.0")
    @DecimalMax(value = "250.0", message = "El peso inicial no puede ser mayor a 250.0")
    private Double pesoInicial;

    @DecimalMin(value = "1.0", message = "La altura debe ser al menos 1.0")
    @DecimalMax(value = "2.5", message = "La altura no puede ser mayor a 2.5")
    private Double altura;

    @ElementCollection
    @CollectionTable(name = "ejercicios_plan", joinColumns = @JoinColumn(name = "plan_id"))
    @Column(name = "ejercicio")
    @NotEmpty(message = "Debe haber al menos 3 ejercicios")
    @Size(min = 3, message = "Debe haber al menos 3 ejercicios")
    private List<String> ejercicios;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public Integer getFrecuenciaSemanal() { return frecuenciaSemanal; }
    public void setFrecuenciaSemanal(Integer frecuenciaSemanal) { this.frecuenciaSemanal = frecuenciaSemanal; }

    public Double getPesoInicial() { return pesoInicial; }
    public void setPesoInicial(Double pesoInicial) { this.pesoInicial = pesoInicial; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public List<String> getEjercicios() { return ejercicios; }
    public void setEjercicios(List<String> ejercicios) { this.ejercicios = ejercicios; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
}