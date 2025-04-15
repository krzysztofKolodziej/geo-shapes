package com.example.geo_shapes.service;

import com.example.geo_shapes.dto.ShapeRequest;
import com.example.geo_shapes.dto.ShapeResponse;
import com.example.geo_shapes.handler.ShapeHandler;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.repository.ShapeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ShapeService {

    private final Map<String, ShapeHandler> handlers;
    private final ShapeRepository shapeRepository;
    private final ShapeMapper shapeMapper;

    public void addShape(ShapeRequest shapeRequest) {
        String type = shapeRequest.type().toLowerCase();
        ShapeHandler handler = handlers.get(type);

        Shape handle = handler.handle(shapeRequest.parameters());
        shapeRepository.save(handle);
    }

    public List<ShapeResponse> getShapes(String type) {
        return shapeRepository.findByType(type).stream()
                .map(shapeMapper::toDto)
                .toList();
    }


}
