package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.response.TransactionFundResponseDTO;
import com.btg.investment.funds.domain.dtos.response.TransactionResponseDTO;
import com.btg.investment.funds.services.ITransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final ITransactionService transactionService;
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<TransactionFundResponseDTO>> getTransactionHistory(@PathVariable String clientId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(transactionService.getTransactionHistory(clientId));
    }
}
