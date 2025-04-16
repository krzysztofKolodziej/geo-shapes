package com.example.geo_shapes.controller;

import com.example.geo_shapes.dto.ShapeRequest;
import com.example.geo_shapes.dto.ShapeResponse;
import com.example.geo_shapes.service.ShapeService;
import com.example.geo_shapes.validation.ValidShapeType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/shapes")
public class ShapeController {

    private final ShapeService shapeService;

    @PostMapping
    public ResponseEntity<String> addShape(@RequestBody @Valid ShapeRequest shapeRequest) {
        shapeService.addShape(shapeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Geometric figure added successfully " + shapeRequest.type());
    }

    @GetMapping
    public ResponseEntity<List<ShapeResponse>> getShapesByType(@RequestParam @ValidShapeType String type) {
        return ResponseEntity.status(HttpStatus.OK).body(shapeService.getShapes(type));
    }
}
