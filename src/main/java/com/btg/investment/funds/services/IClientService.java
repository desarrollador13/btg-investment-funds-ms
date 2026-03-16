package com.btg.investment.funds.services;

import com.btg.investment.funds.domain.dtos.request.ClientRequestDTO;
import com.btg.investment.funds.domain.dtos.response.ClientResponseDTO;
import com.btg.investment.funds.models.Client;

import java.util.Optional;

public interface IClientService {
    Optional<Client> findById(String id);
    ClientResponseDTO save(ClientRequestDTO clientDto);
}
