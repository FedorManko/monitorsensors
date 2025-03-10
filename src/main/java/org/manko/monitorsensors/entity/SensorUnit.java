package org.manko.monitorsensors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is common SensorUnit entity class.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@Getter
@Setter
@Entity
@Table(name = "sensor_units")
public class SensorUnit extends BaseEntity {

    private String sensorUnit;
}
