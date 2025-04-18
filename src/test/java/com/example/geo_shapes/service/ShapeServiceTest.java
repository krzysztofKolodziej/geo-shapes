package com.example.geo_shapes.service;

import com.example.geo_shapes.dto.ShapeRequest;
import com.example.geo_shapes.dto.ShapeResponse;
import com.example.geo_shapes.exception.ShapeInvalidTypeException;
import com.example.geo_shapes.handler.ShapeHandler;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import com.example.geo_shapes.model.Square;
import com.example.geo_shapes.repository.ShapeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShapeServiceTest {

    @Mock
    ShapeRepository shapeRepository;

    @Mock
    ShapeMapper shapeMapper;

    @Mock
    Map<String, ShapeHandler> handlers;

    @InjectMocks
    ShapeService shapeService;

    @Test
    void shouldAddShape_whenTypeIsValid() {
        // given
        ShapeRequest request = new ShapeRequest("square", Map.of("a", 5));
        ShapeHandler mockHandler = mock(ShapeHandler.class);
        Shape shape = new Square();
        when(handlers.get("SQUARE")).thenReturn(mockHandler);
        when(mockHandler.handle(request.parameters())).thenReturn(shape);

        // when
        shapeService.addShape(request);

        // then
        verify(shapeRepository).save(shape);
    }

    @Test
    void shouldThrowException_whenTypeIsInvalid() {
        // given
        ShapeRequest request = new ShapeRequest("triangle", Map.of("a", 5));
        when(handlers.get("TRIANGLE")).thenReturn(null);

        // when / then
        assertThrows(ShapeInvalidTypeException.class, () -> shapeService.addShape(request));
    }

    @Test
    void shouldReturnShapesOfType() {
        // given
        Shape shape = new Square();
        shape.setType(ShapeType.SQUARE);
        when(shapeRepository.existsByType(ShapeType.SQUARE)).thenReturn(true);
        when(shapeRepository.findByType(ShapeType.SQUARE)).thenReturn(List.of(shape));
        when(shapeMapper.toDto(shape)).thenReturn(new ShapeResponse("SQUARE", Map.of("a", 5)));

        // when
        List<ShapeResponse> result = shapeService.getShapes("square");

        // then
        assertEquals(1, result.size());
        assertEquals("SQUARE", result.getFirst().type());
    }

    @Test
    void shouldThrowException_whenTypeNotInEnum() {
        assertThrows(IllegalArgumentException.class, () -> shapeService.getShapes("xyz"));
    }
}