package org.manko.monitorsensors.util;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.entity.Sensor;
import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.util.entity.SensorRandomizer;
import org.manko.monitorsensors.util.entity.SensorTypeRandomizer;
import org.manko.monitorsensors.util.entity.SensorUnitRandomizer;
import org.manko.monitorsensors.util.response.SensorResponseDtoRandomizer;
import org.manko.monitorsensors.util.response.SensorTypeResponseDtoRandomizer;
import org.manko.monitorsensors.util.response.SensorUnitResponseDtoRandomizer;

/**
 * This is a class that provides object randomization & provisioning of fake human-readable data.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class RandomUtils {

    private static final int MINUS_YEARS = 1;
    public static final EasyRandom RANDOM;

    static {

        EasyRandomParameters parameters = new EasyRandomParameters();

        var minDate = LocalDate
            .ofInstant(Instant.now(), ZoneId.systemDefault())
            .minusYears(MINUS_YEARS);

        var maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        parameters.dateRange(minDate, maxDate);
        parameters.stringLengthRange(1, 8);
        parameters.collectionSizeRange(1, 1);
        parameters.randomizationDepth(2);

        randomizeEntities(parameters);
        randomizeResponses(parameters);

        RANDOM = new EasyRandom(parameters);
    }

    private static void randomizeEntities(EasyRandomParameters p) {

        p.randomize(Sensor.class, new SensorRandomizer());
        p.randomize(SensorType.class, new SensorTypeRandomizer());
        p.randomize(SensorUnit.class, new SensorUnitRandomizer());
    }

    private static void randomizeResponses(EasyRandomParameters p) {
        p.randomize(SensorTypeResponseDto.class, new SensorTypeResponseDtoRandomizer());
        p.randomize(SensorUnitResponseDto.class, new SensorUnitResponseDtoRandomizer());
        p.randomize(SensorResponseDto.class, new SensorResponseDtoRandomizer());

    }
}

