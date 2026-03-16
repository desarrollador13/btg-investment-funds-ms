package com.btg.investment.funds.domain.dtos.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FundResponseDTO {
    private String id;
    private String name;
    private Double minimumAmount;
    private String category;
}
