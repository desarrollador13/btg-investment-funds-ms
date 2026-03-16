package com.btg.investment.funds.mappers;

import com.btg.investment.funds.domain.dtos.response.SubscriptionResponseDTO;
import com.btg.investment.funds.models.Subscription;
import org.springframework.stereotype.Component;


@Component
public class FundSubscriptionMapper {

    public SubscriptionResponseDTO toDto(Subscription subscription) {
        return SubscriptionResponseDTO.builder()
            .id(subscription.getId())
            .clientId(subscription.getClientId())
            .fundId(subscription.getFundId())
            .amount(subscription.getAmount())
            .status(subscription.getStatus())
            .openingDate(subscription.getOpeningDate())
            .build();
    }
}
