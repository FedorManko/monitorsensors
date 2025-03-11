package org.manko.monitorsensors.service.vaiidator.impl;


import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.ENTITY_NOT_FOUND_EXCEPTION;
import static org.manko.monitorsensors.service.vaiidator.context.ValidationConstants.EMAIL;

import org.manko.monitorsensors.entity.Customer;
import org.manko.monitorsensors.repository.CustomerRepository;
import org.manko.monitorsensors.service.vaiidator.AbstractDatabaseValidator;
import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class describes custom database validator for logged id {@link Customer} to exist by email.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@Component
public class LoggedInCustomerDatabaseValidator extends AbstractDatabaseValidator<String> {

    private final CustomerRepository customerRepository;

    /**
     * Default constructor that provides injection of required spring beans.
     *
     * @param messageSource      instance of {@link MessageSource}
     * @param customerRepository instance of {@link CustomerRepository}
     */
    public LoggedInCustomerDatabaseValidator(
        MessageSource messageSource,
        CustomerRepository customerRepository
    ) {
        super(messageSource);
        this.customerRepository = customerRepository;
    }

    @Override
    public String discriminator(ValidationContext context) {
        return context.getLoggedInCustomerEmail();
    }

    @Override
    public void resetDiscriminator(ValidationContext context) {
        context.setLoggedInCustomerEmail(null);
    }

    @Override
    public void validate(ValidationContext context) {

        var isCustomerExists = customerRepository.existsByEmail(
            discriminator(context));

        if (!isCustomerExists) {
            throwLocalized(
                ENTITY_NOT_FOUND_EXCEPTION,
                Customer.class,
                EMAIL,
                discriminator(context)
            );
        }
    }
}
