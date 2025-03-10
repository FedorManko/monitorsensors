package org.manko.monitorsensors.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.entity.SensorType;
import org.mapstruct.Mapper;

/**
 * Mapper for converting SensorType entity to DTO and vice versa.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Mapper(componentModel = SPRING)
public interface SensorTypeMapper extends BaseMapper<SensorType, SensorTypeResponseDto> {

    @Override
    SensorTypeResponseDto toDto(SensorType sensorType);

    @Override
    List<SensorTypeResponseDto> toDtoList(List<SensorType> sensorType);
}
