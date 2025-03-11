package org.manko.monitorsensors.service.vaiidator.context;


import lombok.Getter;
import lombok.Setter;
import org.manko.monitorsensors.entity.Customer;
import org.manko.monitorsensors.entity.Sensor;
import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.exception.ApplicationException;
import org.manko.monitorsensors.service.vaiidator.DatabaseValidator;

/**
 * This class describes common validation context for basic database validation. Each class property
 * is linked by {@link DatabaseValidator} implementation and shorthand's database check that exists
 * operation. It allows to run multiple validations on database layer and throw
 * {@link ApplicationException} with specific i18n placeholder usage.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Setter
@Getter
public class ValidationContext {

    /**
     * If set - performs database validation. Ensures, that {@link SensorType} exists by requested
     * id.
     */
    private Long sensorTypeId;

    /**
     * If set - performs database validation. Ensures, that {@link SensorUnit} exists by requested
     * id.
     */
    private Long sensorUnitId;

    /**
     * If set - performs customer database validation. Ensures, that {@link Customer} exists by
     * requested email.
     */
    private String loggedInCustomerEmail;

    /**
     * If set - performs database validation. Ensures, that {@link Sensor} exists by requested
     * id.
     */
    private Long sensorId;
}
