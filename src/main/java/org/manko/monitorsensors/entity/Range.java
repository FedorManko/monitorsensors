package org.manko.monitorsensors.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Range {

    private Integer from;
    private Integer to;
}
