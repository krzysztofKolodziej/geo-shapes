package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;

import java.util.Map;

interface ShapeHandler {
    Shape handle(Map<String, Object> parameters);
}
