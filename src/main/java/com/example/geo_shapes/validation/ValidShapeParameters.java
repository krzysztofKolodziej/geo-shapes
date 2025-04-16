package com.example.geo_shapes.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ShapeParametersValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidShapeParameters {
    String message() default "All parameters must be positive numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
