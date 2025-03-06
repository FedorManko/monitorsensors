package org.manko.monitorsensors.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Unit {

    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("C"),
    PERCENTAGES("%");

    private final String description;
}
