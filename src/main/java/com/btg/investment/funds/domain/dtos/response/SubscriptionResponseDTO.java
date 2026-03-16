package com.btg.investment.funds.domain.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubscriptionResponseDTO {

    private String id;
    private String clientId;
    private String fundId;
    private Double amount;
    private String status;
    private LocalDateTime openingDate;
}
