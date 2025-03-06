package org.manko.monitorsensors.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.manko.monitorsensors.enums.SensorType;

/**
 * This is common Sensor entity class.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@Getter
@Setter
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    @Embedded
    private Range range;

    @Enumerated(EnumType.STRING)
    private SensorType type;

    private String unit;

    private String location;

    private String description;

}
