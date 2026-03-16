package com.btg.investment.funds.domain.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponseDTO {
    private String id;
    private String fundId;
    private String type;
    private Double amount;
    //private LocalDateTime date;
}
