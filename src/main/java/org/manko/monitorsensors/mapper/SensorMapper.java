package org.manko.monitorsensors.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.entity.Sensor;
import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.entity.SensorUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper for converting Sensor entity to DTO and vice versa.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Mapper(componentModel = SPRING)
public interface SensorMapper extends BaseMapper<Sensor, SensorResponseDto> {

    @Override
    @Mapping(target = "sensorType", source = "sensor.type.sensorType")
    @Mapping(target = "sensorUnit", source = "sensor.unit.sensorUnit")
    SensorResponseDto toDto(Sensor sensor);

    @Override
    List<SensorResponseDto> toDtoList(List<Sensor> sensors);

    /**
     * Method maps request to Entity.
     *
     * @param request {@link SensorRequestDto}.
     * @param type    {@link SensorType}.
     * @param unit    {@link SensorUnit}.
     * @return an instance of {@link Sensor}.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    Sensor toEntity(SensorRequestDto request, SensorType type, SensorUnit unit);

    /**
     * Method maps request to Entity.
     *
     * @param sensor  {@link Sensor}.
     * @param request {@link SensorRequestDto}.
     * @param type    {@link SensorType}.
     * @param unit    {@link SensorUnit}.
     * @return an instance of {@link Sensor}.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    Sensor updateEntity(
        @MappingTarget Sensor sensor,
        SensorRequestDto request,
        SensorType type,
        SensorUnit unit);
}
