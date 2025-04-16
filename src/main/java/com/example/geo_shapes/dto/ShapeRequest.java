package com.example.geo_shapes.dto;

import com.example.geo_shapes.validation.ValidShapeParameters;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

public record ShapeRequest(
        @NotBlank(message = "Value must not be empty")
        String type,
        @NotEmpty(message = "Value must not be empty")
        @ValidShapeParameters
        Map<String, Number> parameters
) {
}
