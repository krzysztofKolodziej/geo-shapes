package com.example.geo_shapes.service;

import com.example.geo_shapes.dto.ShapeRequest;
import com.example.geo_shapes.dto.ShapeResponse;
import com.example.geo_shapes.handler.ShapeHandler;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import com.example.geo_shapes.repository.ShapeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ShapeService {

    private final Map<String, ShapeHandler> handlers;
    private final ShapeRepository shapeRepository;
    private final ShapeMapper shapeMapper;

    public void addShape(ShapeRequest shapeRequest) {
        String type = shapeRequest.type().toUpperCase();
        ShapeHandler handler = handlers.get(type);
        Optional.ofNullable(handler).orElseThrow(() ->
                new IllegalArgumentException("Unsupported shape type: " + type)
        );

        Shape handle = handler.handle(shapeRequest.parameters());
        shapeRepository.save(handle);
    }

    public List<ShapeResponse> getShapes(String type) {
        ShapeType shapeType = ShapeType.valueOf(type.toUpperCase());

        return shapeRepository.findByType(shapeType).stream()
                .map(shapeMapper::toDto)
                .toList();
    }


}
