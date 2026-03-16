package com.btg.investment.funds.repositories;

import com.btg.investment.funds.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findByEmail(String email);
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
