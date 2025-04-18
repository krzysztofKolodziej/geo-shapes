package com.example.geo_shapes.exception;

public class ShapeInvalidTypeException extends RuntimeException {

    public ShapeInvalidTypeException(String type) {
        super("Unsupported shape type: " + type);
    }
}
