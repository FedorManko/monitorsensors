package org.manko.monitorsensors.repository;

import java.util.List;
import org.manko.monitorsensors.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * This is an interface that maintain common database operations for Sensor.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    /**
     * Method used to find sensors by name, model.
     *
     * @param searchTerm search parameter.
     * @return a list of {@link Sensor}.
     */
    @Query(value = """
        SELECT * FROM sensors s
        WHERE (:search_term IS NULL
            OR (s.name LIKE CONCAT('%', :search_term, '%')
            OR s.model LIKE CONCAT('%', :search_term, '%')))
        """, nativeQuery = true)
    List<Sensor> findAllWithSearch(@Param("search_term") String searchTerm);
}
