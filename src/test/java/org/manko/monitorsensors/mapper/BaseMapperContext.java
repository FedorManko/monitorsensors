package org.manko.monitorsensors.mapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This class provides a base class with required test context for mapping tests.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapstructMapperConfig.class})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class BaseMapperContext {

}
