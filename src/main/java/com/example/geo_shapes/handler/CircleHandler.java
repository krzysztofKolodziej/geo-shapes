package com.example.geo_shapes.handler;

import com.example.geo_shapes.model.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Qualifier("circle")
public class CircleHandler implements ShapeHandler {

    @Override
    public Shape handle(Map<String, Object> parameters) {
        Shape shape = new Shape();
        shape.setType("circle");
        shape.setParameters(parameters);
        return shape;
    }
}
