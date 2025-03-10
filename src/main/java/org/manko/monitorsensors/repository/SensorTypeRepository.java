package org.manko.monitorsensors.repository;

import org.manko.monitorsensors.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is an interface that maintain common database operations for SensorTypes.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
}
