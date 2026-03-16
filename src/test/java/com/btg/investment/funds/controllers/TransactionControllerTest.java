package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.response.TransactionFundResponseDTO;
import com.btg.investment.funds.services.ITransactionService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    ITransactionService transactionService;

    @Test
    void shouldGetTransactionHistorySuccessfully() throws Exception {
        String clientId = "1";

        TransactionFundResponseDTO responseDTO = TransactionFundResponseDTO.builder()
            .transactionId("1")
            .fundCategory("FPV")
            .type("CANCELLATION")
            .fundName("FPV_BTG_PACTUAL_RECAUDADORA")
            .type("CANCELLATION")
            .build();

        Mockito.when(transactionService.getTransactionHistory(clientId))
            .thenReturn(List.of(responseDTO));

        mockMvc.perform(get("/transactions/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].tipo").value("CANCELLATION"))
            .andExpect(jsonPath("$[0].nombre").value("FPV_BTG_PACTUAL_RECAUDADORA"));
    }
}
