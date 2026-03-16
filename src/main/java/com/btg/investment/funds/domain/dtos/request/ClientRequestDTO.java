package com.btg.investment.funds.domain.dtos.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ClientRequestDTO {
    @NotBlank(message = "name es obligatorio")
    private String name;
    @NotBlank(message = "email es obligatorio")
    private String email;
    @NotBlank(message = "phone es obligatorio")
    private String phone;
    @NotBlank(message = "notificationPreference es obligatorio")
    private String notificationPreference;
}
