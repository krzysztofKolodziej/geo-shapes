package com.example.geo_shapes.service;

import com.example.geo_shapes.dto.ShapeResponse;
import com.example.geo_shapes.model.Shape;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ShapeMapper {

    ShapeResponse toDto(Shape shape);
}
