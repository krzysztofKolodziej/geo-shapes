package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("rectangle")
class RectangleHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Object> parameters) {
        Shape shape = new Shape();
        shape.setType("rectangle");
        shape.setParameters(parameters);
        return shape;
    }
}
