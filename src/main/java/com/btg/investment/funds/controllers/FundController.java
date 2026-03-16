package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.response.FundResponseDTO;
import com.btg.investment.funds.services.IFundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funds")
public class FundController {

    private final IFundService fundService;
    public FundController(IFundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping
    public ResponseEntity<List<FundResponseDTO>> getFunds() {
        return ResponseEntity.status(HttpStatus.OK)
            .body(fundService.getAllFunds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundResponseDTO> getFundById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(fundService.getFundById(id));
    }

}
