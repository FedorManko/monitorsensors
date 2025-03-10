package org.manko.monitorsensors.repository;

import org.manko.monitorsensors.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is an interface that maintain common database operations for Sensor.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
