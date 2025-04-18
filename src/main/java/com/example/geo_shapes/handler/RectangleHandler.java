package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Rectangle;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("RECTANGLE")
class RectangleHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Number> parameters) {
        if (parameters.size() != 2) {
            throw new InvalidShapeParameterException("Rectangle should have two parameters");
        }

        Shape shape = new Rectangle();
        shape.setType(ShapeType.RECTANGLE);
        shape.setParameters(parameters);
        return shape;
    }
}
