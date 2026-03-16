package com.btg.investment.funds.mappers;

import com.btg.investment.funds.domain.dtos.request.ClientRequestDTO;
import com.btg.investment.funds.domain.dtos.response.ClientResponseDTO;
import com.btg.investment.funds.models.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    public static final double INITIAL_CLIENT_BALANCE = 500000.0;

    public Client toClient(ClientRequestDTO clientDto) {
        return Client.builder()
            .name(clientDto.getName())
            .email(clientDto.getEmail())
            .phone(clientDto.getPhone())
            .notificationPreference(clientDto.getNotificationPreference())
            .balance(INITIAL_CLIENT_BALANCE)
            .build();
    }

    public ClientResponseDTO toDto(Client client) {
        return ClientResponseDTO.builder()
            .id(client.getId())
            .name(client.getName())
            .email(client.getEmail())
            .phone(client.getPhone())
            .balance(client.getBalance())
            .notificationPreference(client.getNotificationPreference())
            .build();
    }
}
