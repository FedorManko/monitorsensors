package org.manko.monitorsensors.config.i18n;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This is a class that describes validation message codes to support i18n.
 *
 * @author f.manko
 * @since 07.03.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class I18nMessages {

    public static final String SENSOR_NAME_IS_BLANK = "validation.not_blank.sensor_name";
    public static final String SENSOR_MODEL_IS_BLANK = "validation.not_blank.sensor_model";
    public static final String CUSTOM_VALIDATION_CODE = "validation.custom";
    public static final String SENSOR_NAME_WRONG_SIZE = "validation.size.sensor_name";
    public static final String SENSOR_MODEL_WRONG_SIZE = "validation.size.sensor_model";
    public static final String SENSOR_LOCATION_WRONG_SIZE = "validation.size.sensor_location";
    public static final String SENSOR_DESCRIPTION_WRONG_SIZE = "validation.size.sensor_description";
    public static final String RANGE_WRONG_PARAMETERS = "validation.range";
    public static final String ENTITY_NOT_FOUND = "validation.entity.not_found";
    public static final String SWAGGER_DESCRIPTION = "swagger.description";

}
