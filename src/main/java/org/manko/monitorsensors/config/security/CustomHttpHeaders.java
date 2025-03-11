package org.manko.monitorsensors.config.security;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This is a class that describes custom http headers.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomHttpHeaders {

    public static final String X_CUSTOMER_EMAIL_HEADER = "X-Customer-Email";
}
