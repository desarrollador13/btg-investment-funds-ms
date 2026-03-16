package com.btg.investment.funds.services.impl;

import com.btg.investment.funds.domain.dtos.request.SubscriptionRequestDTO;
import com.btg.investment.funds.domain.dtos.response.SubscriptionResponseDTO;
import com.btg.investment.funds.exceptions.ResourceNotFoundException;
import com.btg.investment.funds.mappers.FundSubscriptionMapper;
import com.btg.investment.funds.mappers.SubscriptionMapper;
import com.btg.investment.funds.mappers.TransactionMapper;
import com.btg.investment.funds.models.Client;
import com.btg.investment.funds.models.Fund;
import com.btg.investment.funds.models.Subscription;
import com.btg.investment.funds.models.Transaction;
import com.btg.investment.funds.repositories.ClientRepository;
import com.btg.investment.funds.repositories.FundRepository;
import com.btg.investment.funds.repositories.SubscriptionRepository;
import com.btg.investment.funds.repositories.TransactionRepository;
import com.btg.investment.funds.services.IFundSubscriptionService;
import com.btg.investment.funds.types.SubscriptionStatus;
import com.btg.investment.funds.types.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FundSubscriptionServiceImpl implements IFundSubscriptionService {

    private final ClientRepository clientRepository;
    private final FundRepository fundRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final SubscriptionMapper subscriptionMapper;
    private final FundSubscriptionMapper fundSubscriptionMapper;

    public FundSubscriptionServiceImpl(
        ClientRepository clientRepository,
        FundRepository fundRepository,
        SubscriptionRepository subscriptionRepository,
        TransactionRepository transactionRepository,
        TransactionMapper transactionMapper,
        SubscriptionMapper subscriptionMapper,
        FundSubscriptionMapper fundSubscriptionMapper
    ) {
        this.clientRepository = clientRepository;
        this.fundRepository = fundRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.subscriptionMapper = subscriptionMapper;
        this.fundSubscriptionMapper = fundSubscriptionMapper;
    }

    @Transactional
    @Override
    public SubscriptionResponseDTO createSubscription(SubscriptionRequestDTO dto) {

        Client client = clientRepository.findById(dto.getClientId())
            .orElseThrow(() -> new ResourceNotFoundException("Client not found" + dto.getClientId()));

        Fund fund = fundRepository.findById(dto.getFundId())
            .orElseThrow(() -> new ResourceNotFoundException("Fund not found" + dto.getFundId()));

        Double minimum = fund.getMinimumAmount();

        if (client.getBalance() < minimum) {
            throw new ResourceNotFoundException(
                "No tiene saldo disponible para vincularse al fondo " + fund.getName()
            );
        }

        client.setBalance(client.getBalance() - minimum);
        clientRepository.save(client);

        Subscription subscription = subscriptionMapper.toSubscription(dto.getClientId(), dto.getFundId(), minimum);

        Subscription savedSubscription = subscriptionRepository.save(subscription);

        Transaction transaction = transactionMapper.toTransaction(dto.getClientId(), dto.getFundId(), minimum);

        transactionRepository.save(transaction);

        return fundSubscriptionMapper.toDto(savedSubscription);
    }

    @Transactional
    @Override
    public SubscriptionResponseDTO cancelSubscription(SubscriptionRequestDTO dto) {

        Subscription subscription = subscriptionRepository
            .findByClientIdAndFundId(dto.getClientId(), dto.getFundId())
            .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));

        Client client = clientRepository.findById(dto.getClientId())
            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        client.setBalance(client.getBalance() + subscription.getAmount());
        clientRepository.save(client);

        subscription.setStatus(SubscriptionStatus.CANCELLED.name());
        Subscription updateSubscription = subscriptionRepository.save(subscription);

        Transaction transaction = Transaction.builder()
            .clientId(dto.getClientId())
            .fundId(dto.getFundId())
            .type(TransactionType.CANCELLATION.name())
            .amount(subscription.getAmount())
            .date(LocalDateTime.now())
            .build();

        transactionRepository.save(transaction);

        return fundSubscriptionMapper.toDto(updateSubscription);
    }

    @Override
    public List<Transaction> getTransactionHistory(String clientId) {
        return transactionRepository.findByClientId(clientId);
    }
}
