package org.manko.monitorsensors.repository;

import java.util.Optional;
import org.manko.monitorsensors.config.security.AppAuthority;
import org.manko.monitorsensors.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * This is an interface that maintain common database operations for Customer.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Method used to find customer role by email.
     *
     * @param email {@link Customer}'s email
     * @return an instance of {@link AppAuthority}
     */
    @Query(
        value = """
            SELECT c.role
            FROM customers c
            WHERE c.email = :email
            """,
        nativeQuery = true)
    Optional<AppAuthority> finCustomerAuthority(String email);

    /**
     * Method returns exists by id {@link Customer} boolean flag.
     *
     * @param email {@link Customer} email
     * @return an instance of boolean value
     */
    boolean existsByEmail(String email);
}
