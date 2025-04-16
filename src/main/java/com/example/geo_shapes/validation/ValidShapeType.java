package com.example.geo_shapes.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ShapeTypeValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidShapeType {
    String message() default "Unsupported shape type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
