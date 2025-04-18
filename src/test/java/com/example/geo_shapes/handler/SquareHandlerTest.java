package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SquareHandlerTest {

    private final SquareHandler handler = new SquareHandler();

    @Test
    void shouldHandleValidSquare() {
        Map<String, Number> params = Map.of("a", 5);
        Shape shape = handler.handle(params);

        assertEquals(ShapeType.SQUARE, shape.getType());
        assertEquals(5, shape.getParameters().get("a"));
    }

    @Test
    void shouldThrowExceptionForTooManyParams() {
        Map<String, Number> params = Map.of("a", 5, "b", 10);

        InvalidShapeParameterException ex = assertThrows(InvalidShapeParameterException.class, () -> handler.handle(params));
        assertEquals("Square should have only one parameter", ex.getMessage());
    }
}