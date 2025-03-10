package org.manko.monitorsensors.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.manko.monitorsensors.dto.request.RangeDto;
import org.manko.monitorsensors.validation.annotation.ValidRangeDto;

/**
 * Class provide custom validator for RangeDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public class RangeDtoValidator
    implements ConstraintValidator<ValidRangeDto, RangeDto> {

    @Override
    public boolean isValid(RangeDto request, ConstraintValidatorContext context) {
        if (request == null) {
            return false;
        }
        Integer from = request.getFrom();
        Integer requestTo = request.getTo();

        return from > 0 && requestTo > 0 && requestTo > from;
    }
}

