package com.example.geo_shapes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shapes")
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShapeType type;

    @ElementCollection
    @CollectionTable(
            name = "shape_parameters",
            joinColumns = @JoinColumn(name = "shape_id")
    )
    @MapKeyColumn(name = "param_key")
    @Column(name = "param_value")
    private Map<String, Double> parameters;
}
