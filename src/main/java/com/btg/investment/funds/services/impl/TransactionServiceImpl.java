package com.btg.investment.funds.services.impl;

import com.btg.investment.funds.domain.dtos.response.TransactionFundResponseDTO;
import com.btg.investment.funds.exceptions.ResourceNotFoundException;
import com.btg.investment.funds.mappers.TransactionMapper;
import com.btg.investment.funds.models.Fund;
import com.btg.investment.funds.models.Transaction;
import com.btg.investment.funds.repositories.FundRepository;
import com.btg.investment.funds.repositories.TransactionRepository;
import com.btg.investment.funds.services.ITransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final FundRepository fundRepository;

    public TransactionServiceImpl(
        TransactionRepository transactionRepository,
        TransactionMapper transactionMapper,
        FundRepository fundRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.fundRepository = fundRepository;
    }

    @Override
    public List<TransactionFundResponseDTO> getTransactionHistory(String clientId) {
        List<Transaction> transactions = transactionRepository.findByClientId(clientId);
        return transactions.stream()
            .map(tr -> {
                Fund fund = fundRepository.findById(tr.getFundId())
                    .orElseThrow(() -> new ResourceNotFoundException("Fund not found"));
                return transactionMapper.toDto(tr, fund);
            }).collect(Collectors.toList());
    }
}

