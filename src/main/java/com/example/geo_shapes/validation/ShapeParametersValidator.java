package com.example.geo_shapes.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class ShapeParametersValidator implements ConstraintValidator<ValidShapeParameters, Map<String, Double>> {

    @Override
    public boolean isValid(Map<String, Double> parameters, ConstraintValidatorContext context) {
        if (parameters == null || parameters.isEmpty()) return false;

        return parameters.values().stream()
                .allMatch(value -> value != null && value > 0);
    }
}
