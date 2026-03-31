package com.programacion4.unidad4ej5.feature.socio;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AdultoValidator implements ConstraintValidator<Adulto, LocalDate> {

    @Override
    public void initialize(Adulto constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate fechaNacimiento, ConstraintValidatorContext context) {
        if (fechaNacimiento == null) {
            return true; // Dejar que @NotNull maneje null
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
}