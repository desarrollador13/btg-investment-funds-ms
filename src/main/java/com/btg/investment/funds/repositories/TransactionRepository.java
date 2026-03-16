package com.btg.investment.funds.repositories;

import com.btg.investment.funds.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByClientId(String clientId);
}
