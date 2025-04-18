package com.example.geo_shapes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCLE")
public class Circle extends Shape {
}
