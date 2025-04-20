package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleHandlerTest {

    private final CircleHandler handler = new CircleHandler();

    @Test
    void shouldHandleValidCircle() {
        Map<String, Double> params = Map.of("r", 3.5);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.CIRCLE, shape.getType());
        assertEquals(3.5, shape.getParameters().get("r"));
    }

    @Test
    void shouldThrowExceptionWhenMoreThanOneParameter() {
        Map<String, Double> params = Map.of("r", 3.5, "extra", 2.0);

        InvalidShapeParameterException ex = assertThrows(InvalidShapeParameterException.class, () -> handler.handle(params));
        assertEquals("Circle should have only one parameter", ex.getMessage());
    }
}

