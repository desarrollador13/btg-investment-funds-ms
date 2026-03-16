package com.btg.investment.funds.mappers;

import com.btg.investment.funds.models.Subscription;
import com.btg.investment.funds.types.SubscriptionStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class SubscriptionMapper {

    public Subscription toSubscription(String clientId, String fundId,Double minimum) {
        return Subscription.builder()
            .clientId(clientId)
            .fundId(fundId)
            .amount(minimum)
            .status(SubscriptionStatus.ACTIVE.name())
            .openingDate(LocalDateTime.now())
            .build();
    }
}
