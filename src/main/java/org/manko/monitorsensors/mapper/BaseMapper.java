package org.manko.monitorsensors.mapper;

import java.util.List;

/**
 * Mapper for converting E entity to D dto and vice versa.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface BaseMapper<E, D> {

    /**
     * Maps the given entity to a DTO.
     *
     * @param entity the entity to map.
     * @return the mapped DTO.
     */
    D toDto(E entity);

    /**
     * Maps the given list entity to a list DTO.
     *
     * @param entities the list of entity to map.
     * @return the list of mapped DTO.
     */
    List<D> toDtoList(List<E> entities);
}
