package com.btg.investment.funds.services;

import com.btg.investment.funds.domain.dtos.request.SubscriptionRequestDTO;
import com.btg.investment.funds.domain.dtos.response.SubscriptionResponseDTO;
import com.btg.investment.funds.models.Subscription;
import com.btg.investment.funds.models.Transaction;

import java.util.List;

public interface IFundSubscriptionService {
    SubscriptionResponseDTO createSubscription(SubscriptionRequestDTO dto);
    SubscriptionResponseDTO cancelSubscription(SubscriptionRequestDTO dto);
    List<Transaction> getTransactionHistory(String clientId);

}
