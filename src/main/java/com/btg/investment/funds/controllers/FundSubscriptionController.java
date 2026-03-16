package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.request.SubscriptionRequestDTO;
import com.btg.investment.funds.domain.dtos.response.SubscriptionResponseDTO;
import com.btg.investment.funds.services.IFundSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subscriptions")
public class FundSubscriptionController {

    private final IFundSubscriptionService fundSubscriptionService;

    public FundSubscriptionController(IFundSubscriptionService fundSubscriptionService) {
        this.fundSubscriptionService = fundSubscriptionService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<SubscriptionResponseDTO> createSubscription(
        @Valid @RequestBody SubscriptionRequestDTO dto
        ) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(fundSubscriptionService.createSubscription(dto));
    }

    @PostMapping("/cancel")
    public ResponseEntity<SubscriptionResponseDTO> cancelSubscription(
        @Valid @RequestBody SubscriptionRequestDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(fundSubscriptionService.cancelSubscription(dto));
    }
}
