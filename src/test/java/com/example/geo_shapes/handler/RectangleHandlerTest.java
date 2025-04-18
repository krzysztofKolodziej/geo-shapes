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
        Map<String, Number> params = Map.of("a", 5, "b", 10);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.RECTANGLE, shape.getType());
        assertEquals(2, shape.getParameters().size());
    }

    @Test
    void shouldThrowExceptionForTooManyParams() {
        Map<String, Number> params = Map.of("a", 5, "b", 10, "c", 15);

        InvalidShapeParameterException ex = assertThrows(InvalidShapeParameterException.class, () -> handler.handle(params));
        assertEquals("Rectangle should have two parameters", ex.getMessage());
    }
}