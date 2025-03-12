package org.manko.monitorsensors.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.manko.monitorsensors.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This is an abstract class that contains common logic for all controller tests.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected CustomerRepository customerRepository;
}
