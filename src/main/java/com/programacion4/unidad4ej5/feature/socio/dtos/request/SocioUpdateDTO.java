package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import com.programacion4.unidad4ej5.feature.socio.ValidationGroups;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

public class SocioUpdateDTO {

    @NotNull(groups = ValidationGroups.Update.class, message = "El ID del socio es obligatorio en actualización")
    @Null(groups = ValidationGroups.Create.class, message = "El ID no debe proporcionarse en creación")
    private Long id;

    @URL(message = "La URL de la foto debe ser válida")
    private String urlFoto;

    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @Pattern(regexp = "\\S+", message = "El alias no puede contener espacios")
    private String alias;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}