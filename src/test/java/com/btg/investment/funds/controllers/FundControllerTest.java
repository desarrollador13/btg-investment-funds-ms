package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.response.FundResponseDTO;
import com.btg.investment.funds.services.IFundService;
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

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FundControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    IFundService fundService;

    @Test
    void shouldGetFundSuccessfully() throws Exception {
        FundResponseDTO responseDTO = FundResponseDTO.builder()
            .id("1")
            .name("DEUDAPRIVADA")
            .category("FIC")
            .minimumAmount(500000.0)
            .build();

        Mockito.when(fundService.getAllFunds())
            .thenReturn(List.of(responseDTO));

        mockMvc.perform(get("/funds"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].id").value("1"))
            .andExpect(jsonPath("$[0].name").value("DEUDAPRIVADA"))
            .andExpect(jsonPath("$[0].category").value("FIC"));
    }
}
