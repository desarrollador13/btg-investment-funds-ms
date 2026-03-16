package com.btg.investment.funds.domain.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {

    private String message;
    private String error;
    private LocalDateTime timestamp;
    private Map<String, String> details;
}
