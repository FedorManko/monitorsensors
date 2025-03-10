package org.manko.monitorsensors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is common SensorType entity class.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@Getter
@Setter
@Entity
@Table(name = "sensor_types")
public class SensorType extends BaseEntity {

    private String sensorType;
}
