package org.manko.monitorsensors.config.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * This is enum that defines authority to application.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public enum AppAuthority {
    VIEWER,
    ADMINISTRATOR;

    /**
     * Method converts {@link AppAuthority} to spring security {@link SimpleGrantedAuthority}.
     *
     * @return an instance of {@link SimpleGrantedAuthority}.
     */
    public SimpleGrantedAuthority toAuthority() {
        return new SimpleGrantedAuthority("ROLE_%s".formatted(this.name()));
    }
}
