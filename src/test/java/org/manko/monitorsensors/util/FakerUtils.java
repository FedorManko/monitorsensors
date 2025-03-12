package org.manko.monitorsensors.util;


import java.util.Locale;
import net.datafaker.Faker;

/**
 * This is a class that provides fake test data for randomization.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class FakerUtils {

    public static final Faker FAKE = new Faker(Locale.ENGLISH);

    /**
     * Generates common fake value for sensor name.
     *
     * @return an instance of {@link String}
     */
    public static String fakeSensorName() {
        return "%s".formatted(FAKE.text());
    }

    /**
     * Generates common fake value for description.
     *
     * @return an instance of {@link String}
     */
    public static String fakeDescription() {
        return FAKE.text().text(25, 500, true, true);
    }


    /**
     * Generates common fake ID.
     *
     * @return an instance of {@link Long}
     */
    public static Long fakeId() {
        return FAKE.number().numberBetween(1L, 100L);
    }

    /**
     * Generates common fake sensor type.
     *
     * @return an instance of {@link String}
     */
    public static String fakeSensorType() {
        return "SensorType_" + FAKE.number().numberBetween(1, 101);
    }

    /**
     * Generates common fake sensor unit.
     *
     * @return an instance of {@link String}
     */
    public static String fakeSensorUnit() {
        return "SensorUnit_" + FAKE.number().numberBetween(1, 101);
    }
}
