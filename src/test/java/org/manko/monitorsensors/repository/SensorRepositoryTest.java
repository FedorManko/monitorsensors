package org.manko.monitorsensors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql("/sql/sensors.sql")
class SensorRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    @DisplayName("Should find all sensors")
    void findAll() {

        List<Sensor> sensorTypes = sensorRepository.findAll();
        assertThat(sensorTypes).hasSize(2);
    }

    @Test
    @DisplayName("Should find all sensors with search")
    void findAllWithSearch() {

        List<Sensor> sensorTypes = sensorRepository.findAllWithSearch("1");
        assertThat(sensorTypes).hasSize(1);
    }
}
