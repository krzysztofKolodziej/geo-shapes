package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;

import java.util.Map;

public interface ShapeHandler {
    Shape handle(Map<String, Double> parameters);
}
