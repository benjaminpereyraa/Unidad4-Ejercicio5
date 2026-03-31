package com.programacion4.unidad4ej5.feature.socio;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AdultoValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Adulto {
    String message() default "El socio debe tener al menos 18 años";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}