package com.example.geo_shapes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SQUARE")
public class Square extends Shape {
}
