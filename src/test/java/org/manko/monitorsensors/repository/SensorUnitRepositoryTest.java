package org.manko.monitorsensors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.entity.SensorUnit;
import org.springframework.beans.factory.annotation.Autowired;

class SensorUnitRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private SensorUnitRepository sensorUnitRepository;

    @Test
    @DisplayName("Should find all sensor units")
    void findAll() {

        List<SensorUnit> sensorTypes = sensorUnitRepository.findAll();
        assertThat(sensorTypes.getFirst().getSensorUnit()).isEqualTo("voltage");
    }
}
