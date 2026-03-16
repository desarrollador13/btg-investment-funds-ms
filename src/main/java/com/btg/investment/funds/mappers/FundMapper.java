package com.btg.investment.funds.mappers;

import com.btg.investment.funds.domain.dtos.response.FundResponseDTO;
import com.btg.investment.funds.models.Fund;
import org.springframework.stereotype.Component;

@Component
public class FundMapper {

    public FundResponseDTO toDto(Fund fund) {
        return FundResponseDTO.builder()
            .id(fund.getId())
            .name(fund.getName())
            .minimumAmount(fund.getMinimumAmount())
            .category(fund.getCategory())
            .build();
    }

}
