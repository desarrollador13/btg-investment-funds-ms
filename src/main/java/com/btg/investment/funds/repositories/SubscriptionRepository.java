package com.btg.investment.funds.repositories;

import com.btg.investment.funds.models.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    List<Subscription> findByClientId(String clientId);

    Optional<Subscription> findByClientIdAndFundId(String clientId, String fundId);
}
