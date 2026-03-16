package com.btg.investment.funds.domain.dtos.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class SubscriptionRequestDTO {

    @NotBlank(message = "clientId es obligatorio")
    private String clientId;

    @NotBlank(message = "fundId es obligatorio")
    private String fundId;

}
