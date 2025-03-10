package org.manko.monitorsensors.config.i18n;

import static org.manko.monitorsensors.config.i18n.I18nMessages.ENTITY_NOT_FOUND;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enumeration provides constant i18n placeholders.
 *
 * @author f.manko
 * @since 07.03.2025
 */
@Getter
@RequiredArgsConstructor
public enum I18nPlaceholders {

    SENSOR_NAME_IS_BLANK(I18nMessages.SENSOR_NAME_IS_BLANK),
    SENSOR_MODEL_IS_BLANK(I18nMessages.SENSOR_MODEL_IS_BLANK),
    CUSTOM_VALIDATION_EXCEPTION(I18nMessages.CUSTOM_VALIDATION_CODE),
    SENSOR_NAME_WRONG_SIZE(I18nMessages.SENSOR_NAME_WRONG_SIZE),
    SENSOR_MODEL_WRONG_SIZE(I18nMessages.SENSOR_MODEL_WRONG_SIZE),
    SENSOR_LOCATION_WRONG_SIZE(I18nMessages.SENSOR_LOCATION_WRONG_SIZE),
    SENSOR_DESCRIPTION_WRONG_SIZE(I18nMessages.SENSOR_DESCRIPTION_WRONG_SIZE),
    RANGE_WRONG_PARAMETERS(I18nMessages.RANGE_WRONG_PARAMETERS),
    ENTITY_NOT_FOUND_EXCEPTION(ENTITY_NOT_FOUND),
    SWAGGER_DESCRIPTION(I18nMessages.SWAGGER_DESCRIPTION);

    private final String placeholder;

}
