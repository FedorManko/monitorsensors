package org.manko.monitorsensors.repository;

import org.manko.monitorsensors.entity.SensorUnit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is an interface that maintain common database operations for SensorUnit.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface SensorUnitRepository extends JpaRepository<SensorUnit, Long> {
}
