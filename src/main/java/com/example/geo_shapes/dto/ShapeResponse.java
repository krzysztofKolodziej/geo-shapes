package com.example.geo_shapes.dto;

import java.util.Map;

public record ShapeResponse(
        String type,
        Map<String, Object> parameters
) {
}
