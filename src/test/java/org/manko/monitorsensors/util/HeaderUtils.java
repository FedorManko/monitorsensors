package org.manko.monitorsensors.util;


import org.springframework.http.HttpHeaders;

/**
 * This is a utility class that provides static factory methods for security header management.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@SuppressWarnings("PMD.LooseCoupling")
public class HeaderUtils {

    private HeaderUtils() {
    }

    public static final String ADMIN_USERNAME = "admin";
    public static final String VIEWER_EMAIL = "viewer@mail.com";


    /**
     * Preconfigured auth header for email.
     *
     * @return instance of {@link HttpHeaders}
     */
    public static HttpHeaders emailHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Email", VIEWER_EMAIL);
        return headers;
    }
}
