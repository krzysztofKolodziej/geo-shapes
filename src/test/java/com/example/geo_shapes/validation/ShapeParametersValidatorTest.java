package com.example.geo_shapes.validation;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShapeParametersValidatorTest {

    private final ShapeParametersValidator validator = new ShapeParametersValidator();

    @Test
    void shouldReturnTrueForAllPositiveValues() {
        Map<String, Double> params = Map.of("a", 5.0, "b", 10.5);
        assertTrue(validator.isValid(params, null));
    }

    @Test
    void shouldReturnFalseForNegativeValue() {
        Map<String, Double> params = Map.of("a", -5.0);
        assertFalse(validator.isValid(params, null));
    }

    @Test
    void shouldReturnFalseForNullParameterMap() {
        assertFalse(validator.isValid(null, null));
    }

    @Test
    void shouldReturnFalseForEmptyParameterMap() {
        assertFalse(validator.isValid(Map.of(), null));
    }

    @Test
    void shouldReturnFalseForNullValueInMap() {
        Map<String, Double> params = new HashMap<>();
        params.put("a", null);
        assertFalse(validator.isValid(params, null));
    }
}