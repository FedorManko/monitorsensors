package org.manko.monitorsensors.config.security.access;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.manko.monitorsensors.config.security.EmailRoleFilter;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Custom annotation, that defines set of roles for app administrator
 * using {@link EmailRoleFilter} security filter.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("""
        hasAnyRole(
            T(org.manko.monitorsensors.config.security.AppAuthority).ADMINISTRATOR.name()
        )
    """)
public @interface AdminAccess {

}
