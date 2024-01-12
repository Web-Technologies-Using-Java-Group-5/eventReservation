package com.univbuc.eventreservation.admin.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.admin.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdminFlowIntegrationTest {

    public static final Event INPUT_EVENT = new Event(0, "testEvent", "description", 100);
    public static final Event RESULTED_EVENT = new Event(1, INPUT_EVENT.getName(), INPUT_EVENT.getDescription(),
            INPUT_EVENT.getCapacity());
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AdminService adminService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void addEvent() throws Exception {
        // Arrange
        when(adminService.addEvent(INPUT_EVENT)).thenReturn(RESULTED_EVENT);

        // Act & Assert
        mockMvc.perform(post("/admin/events").content(
                        mapper.writerWithDefaultPrettyPrinter().writeValueAsString(INPUT_EVENT)
                ).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(RESULTED_EVENT)));
    }

}