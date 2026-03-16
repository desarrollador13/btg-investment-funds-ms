package com.btg.investment.funds.domain.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionFundResponseDTO {
    @JsonProperty("Id")
    private String transactionId;
    @JsonProperty("tipo")
    private String type;
    //@JsonProperty("Monto")// OPENING o CANCELLATION
    //private Double amount;
    //@JsonProperty("Fecha")
   // private LocalDateTime date;
    // Datos del fondo
    //private String fundId;
    @JsonProperty("nombre")
    private String fundName;
    @JsonProperty("monto minimo")
    private Double fundMinimumAmount;
    @JsonProperty("monto Categoria")
    private String fundCategory;
}
