package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import java.util.List;

public class PlanCreateDTO {

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

    @NotEmpty(message = "Debe haber al menos 3 ejercicios")
    @Size(min = 3, message = "Debe haber al menos 3 ejercicios")
    private List<String> ejercicios;

    // Getters y Setters
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
}