package com.btg.investment.funds.domain.dtos.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Double balance;
    private String notificationPreference;
}
