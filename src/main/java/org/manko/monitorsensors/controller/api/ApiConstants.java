package org.manko.monitorsensors.controller.api;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class that contains common api description constants.
 *
 * @author f.manko
 * @since 10.03.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiConstants {

    public static final String OK_CODE = "200";
    public static final String UNAUTHORIZED_CODE = "401";
    public static final String FORBIDDEN_CODE = "403";

    public static final String UNAUTHORIZED_MESSAGE = "Unauthorized";
    public static final String FORBIDDEN_MESSAGE = "Forbidden";

}
