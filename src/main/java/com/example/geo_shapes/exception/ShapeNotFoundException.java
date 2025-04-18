package com.example.geo_shapes.exception;

public class ShapeNotFoundException extends RuntimeException {

    public ShapeNotFoundException(String type) {
        super("Not found shape " + type);
    }
}
