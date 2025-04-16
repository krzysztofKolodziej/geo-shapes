package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class RectangleHandlerTest {

    private final RectangleHandler handler = new RectangleHandler();

    @Test
    void shouldHandleValidRectangleWithTwoParams() {
        Map<String, Number> params = Map.of("a", 5, "b", 10);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.RECTANGLE, shape.getType());
        assertEquals(2, shape.getParameters().size());
    }

    @Test
    void shouldHandleValidRectangleWithOneParam() {
        Map<String, Number> params = Map.of("a", 5);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.RECTANGLE, shape.getType());
        assertEquals(1, shape.getParameters().size());
    }

    @Test
    void shouldThrowExceptionForTooManyParams() {
        Map<String, Number> params = Map.of("a", 5, "b", 10, "c", 15);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> handler.handle(params));
        assertEquals("Rectangle should have one or two parameters", ex.getMessage());
    }
}