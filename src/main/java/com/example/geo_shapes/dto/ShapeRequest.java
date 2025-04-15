package com.example.geo_shapes.dto;

import java.util.Map;

public record ShapeRequest(
        String type,
        Map<String, Object> parameters
) {
}
