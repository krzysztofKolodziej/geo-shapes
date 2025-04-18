package com.example.geo_shapes.handler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.model.Shape;
import com.example.geo_shapes.model.ShapeType;
import com.example.geo_shapes.model.Square;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("SQUARE")
class SquareHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Number> parameters) {
        if (parameters.size() > 1) {
            throw new InvalidShapeParameterException("Square should have only one parameter");
        }

        Shape shape = new Square();
        shape.setType(ShapeType.SQUARE);
        shape.setParameters(parameters);
        return shape;
    }
}
