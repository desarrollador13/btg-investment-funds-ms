package com.btg.investment.funds.repositories;


import com.btg.investment.funds.models.Fund;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundRepository extends MongoRepository<Fund, String> {
}
