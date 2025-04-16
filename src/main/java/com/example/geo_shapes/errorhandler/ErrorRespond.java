package com.example.geo_shapes.errorhandler;

import org.springframework.http.HttpStatusCode;

public record ErrorRespond(
        HttpStatusCode status,
        String message
) {
}
