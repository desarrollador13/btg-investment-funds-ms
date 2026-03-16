package com.btg.investment.funds.controllers;

import com.btg.investment.funds.domain.dtos.request.ClientRequestDTO;
import com.btg.investment.funds.domain.dtos.response.ClientResponseDTO;
import com.btg.investment.funds.services.IClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IClientService clientService;

    @Test
    void shouldCreateClientSuccessfully() throws Exception {
        ClientRequestDTO request = ClientRequestDTO.builder()
            .name("Jona Pinto")
            .email("jona@email.com")
            .phone("3001234567")
            .notificationPreference("SMS")
            .build();

        ClientResponseDTO response = ClientResponseDTO.builder()
            .id("1")
            .name("Jona Pinto")
            .email("jona@email.com")
            .phone("3001234567")
            .balance(500000.0)
            .notificationPreference("EMAIL")
            .build();
        Mockito.when(clientService.save(Mockito.any(ClientRequestDTO.class)))
            .thenReturn(response);

        mockMvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value("1"))
            .andExpect(jsonPath("$.name").value("Jona Pinto"));
    }
}
