package com.example.geo_shapes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RECTANGLE")
public class Rectangle extends Shape{
}
