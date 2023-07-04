package com.kerrrusha.transportrental.controller;

import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.service.TransportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TransportControllerTest {

    @Mock
    TransportService service;

    @InjectMocks
    TransportController controller;

    Set<Transport> transportSet;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        transportSet = new HashSet<>();
        transportSet.add(Transport.builder().id(1L).build());
        transportSet.add(Transport.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void index() throws Exception {
        mockMvc.perform(get("/transport/"))
                .andExpect(status().isOk())
                .andExpect(view().name("transport/index"))
                .andExpect(model().attributeExists("transportList"));
    }

}
