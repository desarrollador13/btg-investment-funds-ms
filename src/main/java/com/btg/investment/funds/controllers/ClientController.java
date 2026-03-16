package com.btg.investment.funds.controllers;


import com.btg.investment.funds.domain.dtos.request.ClientRequestDTO;
import com.btg.investment.funds.domain.dtos.response.ClientResponseDTO;
import com.btg.investment.funds.services.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;
    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO clientDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(clientService.save(clientDto));
    }

}
