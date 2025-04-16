package com.example.geo_shapes.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTypeValidatorTest {

    private final ShapeTypeValidator validator = new ShapeTypeValidator();

    @Test
    void shouldReturnTrueForValidShapeType() {
        assertTrue(validator.isValid("circle", null));
        assertTrue(validator.isValid("RECTANGLE", null));
    }

    @Test
    void shouldReturnFalseForInvalidShapeType() {
        assertFalse(validator.isValid("triangle", null));
        assertFalse(validator.isValid("xyz", null));
    }

    @Test
    void shouldReturnFalseForNull() {
        assertFalse(validator.isValid(null, null));
    }
}