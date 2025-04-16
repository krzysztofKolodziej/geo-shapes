package com.example.geo_shapes.validation;

import com.example.geo_shapes.model.ShapeType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShapeTypeValidator implements ConstraintValidator<ValidShapeType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        try {
            ShapeType.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
