package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.request.SubscriptionRequestDTO;
import com.btg.investment.funds.domain.dtos.response.SubscriptionResponseDTO;
import com.btg.investment.funds.services.IFundSubscriptionService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FundSubscriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    IFundSubscriptionService fundSubscriptionService;

    @Test
    void shouldCreateSubscriptionuccessfully() throws Exception {
        SubscriptionRequestDTO requestDTO = SubscriptionRequestDTO.builder()
            .clientId("1")
            .fundId("1")
            .build();

        SubscriptionResponseDTO responseDTO = SubscriptionResponseDTO.builder()
                .id("1")
                .clientId("1")
                .fundId("1")
                .amount(500000.0)
                .status("ACTIVE")
                .build();

        Mockito.when(fundSubscriptionService.createSubscription(requestDTO))
            .thenReturn(responseDTO);

        mockMvc.perform(post("/subscriptions/subscribe")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value("1"))
            .andExpect(jsonPath("$.clientId").value("1"))
            .andExpect(jsonPath("$.fundId").value("1"))
            .andExpect(jsonPath("$.status").value("ACTIVE"));
    }

    @Test
    void shouldCancelSubscriptionuccessfully() throws Exception {
        SubscriptionRequestDTO requestDTO = SubscriptionRequestDTO.builder()
            .clientId("1")
            .fundId("1")
            .build();

        SubscriptionResponseDTO responseDTO = SubscriptionResponseDTO.builder()
            .id("1")
            .clientId("1")
            .fundId("1")
            .amount(500000.0)
            .status("CANCELLED")
            .build();

        Mockito.when(fundSubscriptionService.createSubscription(requestDTO))
            .thenReturn(responseDTO);

        mockMvc.perform(post("/subscriptions/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
            .andExpect(jsonPath("$.id").value("1"))
            .andExpect(jsonPath("$.clientId").value("1"))
            .andExpect(jsonPath("$.fundId").value("1"))
            .andExpect(jsonPath("$.status").value("CANCELLED"));
    }
}
