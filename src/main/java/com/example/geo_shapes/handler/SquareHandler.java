package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("SQUARE")
class SquareHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Number> parameters) {
        if (parameters.size() > 1) {
            throw new IllegalArgumentException("Square should have only one parameter");
        }

        Shape shape = new Shape();
        shape.setType(ShapeType.SQUARE);
        shape.setParameters(parameters);
        return shape;
    }
}
