package com.kerrrusha.transportrental.controller;

import com.kerrrusha.transportrental.model.RentalLog;
import com.kerrrusha.transportrental.service.RentalLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class TransportControllerTest {

    RentalLogController rentalLogController;

    @Mock
    RentalLogService rentalLogService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        rentalLogController = new RentalLogController(rentalLogService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(rentalLogController).build();
        mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andExpect(view().name("log/index"));
    }

    @Test
    void index() {
        //given
        Set<RentalLog> input = new HashSet<>();
        input.add(new RentalLog(1L));
        input.add(new RentalLog(2L));

        when(rentalLogService.findAll()).thenReturn(input);
        ArgumentCaptor<Set<RentalLog>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String result = rentalLogController.index(model);

        //then
        assertEquals(result, "log/index");
        verify(rentalLogService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("rentalLogs"), argumentCaptor.capture());
        Set<RentalLog> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

}