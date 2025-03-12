package org.manko.monitorsensors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.entity.SensorType;
import org.springframework.beans.factory.annotation.Autowired;

class SensorTypeRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private SensorTypeRepository sensorTypeRepository;

    @Test
    @DisplayName("Should find all sensor types")
    void findAll() {

        List<SensorType> sensorTypes = sensorTypeRepository.findAll();
        assertThat(sensorTypes).hasSize(4);
    }
}
