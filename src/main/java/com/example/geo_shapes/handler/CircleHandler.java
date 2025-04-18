package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Circle;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("CIRCLE")
class CircleHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Number> parameters) {
        if (parameters.size() > 1) {
            throw new InvalidShapeParameterException("Circle should have only one parameter");
        }

        Shape shape = new Circle();
        shape.setType(ShapeType.CIRCLE);
        shape.setParameters(parameters);
        return shape;
    }
}
