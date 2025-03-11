package org.manko.monitorsensors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is common Customer entity class.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String email;

    private String role;

}
