package com.btg.investment.funds.services.impl;

import com.btg.investment.funds.domain.dtos.request.ClientRequestDTO;
import com.btg.investment.funds.domain.dtos.response.ClientResponseDTO;
import com.btg.investment.funds.exceptions.ResourceNotFoundException;
import com.btg.investment.funds.mappers.ClientMapper;
import com.btg.investment.funds.models.Client;
import com.btg.investment.funds.repositories.ClientRepository;
import com.btg.investment.funds.services.IClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientResponseDTO save(ClientRequestDTO clientDto) {
        Client client = clientMapper.toClient(clientDto);

        if (clientRepository.existsByEmail(clientDto.getEmail())) {
            throw new ResourceNotFoundException("Ya existe un cliente con ese email");
        }

        if (clientRepository.existsByPhone(clientDto.getPhone())) {
            throw new ResourceNotFoundException("Ya existe un cliente con ese teléfono");
        }

        Client savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

}
