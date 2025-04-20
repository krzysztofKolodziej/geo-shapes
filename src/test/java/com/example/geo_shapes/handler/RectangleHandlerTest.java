package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class RectangleHandlerTest {

    private final RectangleHandler handler = new RectangleHandler();

    @Test
    void shouldHandleValidRectangleWithTwoParams() {
        Map<String, Double> params = Map.of("a", 5.0, "b", 10.0);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.RECTANGLE, shape.getType());
        assertEquals(2, shape.getParameters().size());
    }

    @Test
    void shouldThrowExceptionForTooManyParams() {
        Map<String, Double> params = Map.of("a", 5.0, "b", 10.0, "c", 15.0);

        InvalidShapeParameterException ex = assertThrows(InvalidShapeParameterException.class, () -> handler.handle(params));
        assertEquals("Rectangle should have two parameters", ex.getMessage());
    }
}