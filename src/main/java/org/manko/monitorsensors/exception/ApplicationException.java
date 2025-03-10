package org.manko.monitorsensors.exception;


import java.io.Serial;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

/**
 * This is a class, that describes the common application exception, related to business failures.
 *
 * @author f.mamko
 * @since 09.03.2025
 */
@Getter
@Builder
public class ApplicationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String errorMessage;
    private final Map<String, Object> meta;

    /**
     * Default constructor for custom exception with mandatory runtime exception parameters.
     *
     * @param errorMessage exception message
     * @param meta         custom exception metadata, like timestamps, parameters & auxiliary
     *                     values
     */
    public ApplicationException(String errorMessage, Map<String, Object> meta) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.meta = meta;
    }
}
