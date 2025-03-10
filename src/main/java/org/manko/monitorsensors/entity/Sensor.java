package org.manko.monitorsensors.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 * This is common Sensor entity class.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@Getter
@Setter
@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity {

    private String name;

    private String model;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Range range;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_type_id", referencedColumnName = "id")
    private SensorType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_unit_id", referencedColumnName = "id")
    private SensorUnit unit;

    private String location;

    private String description;

}
