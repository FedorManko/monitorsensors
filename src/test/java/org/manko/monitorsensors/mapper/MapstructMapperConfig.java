package org.manko.monitorsensors.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * This configuration file provides additional bean instantiation for mapstruct mappers, required to
 * run database layer tests.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@TestConfiguration
public class MapstructMapperConfig {

    @Bean
    public SensorMapper sensorMapper() {
        return Mappers.getMapper(SensorMapper.class);
    }

    @Bean
    public SensorUnitMapper sensorUnitMapper() {
        return Mappers.getMapper(SensorUnitMapper.class);
    }

    @Bean
    public SensorTypeMapper sensorTypeMapper() {
        return Mappers.getMapper(SensorTypeMapper.class);
    }
}
