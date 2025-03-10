package org.manko.monitorsensors.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.entity.SensorUnit;
import org.mapstruct.Mapper;

/**
 * Mapper for converting SensorUnit entity to DTO and vice versa.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Mapper(componentModel = SPRING)
public interface SensorUnitMapper extends BaseMapper<SensorUnit, SensorUnitResponseDto> {

    @Override
    SensorUnitResponseDto toDto(SensorUnit sensorUnit);

    @Override
    List<SensorUnitResponseDto> toDtoList(List<SensorUnit> sensorUnits);
}
