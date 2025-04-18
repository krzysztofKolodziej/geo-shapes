package com.example.geo_shapes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Number> parameters;
}
