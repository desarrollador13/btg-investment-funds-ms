package com.btg.investment.funds.mappers;

import com.btg.investment.funds.domain.dtos.response.TransactionFundResponseDTO;
import com.btg.investment.funds.domain.dtos.response.TransactionResponseDTO;
import com.btg.investment.funds.models.Fund;
import com.btg.investment.funds.models.Transaction;
import com.btg.investment.funds.types.TransactionType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


@Component
public class TransactionMapper {

    public Transaction toTransaction(String clientId, String fundId, Double minimum) {
        return  Transaction.builder()
            .clientId(clientId)
            .fundId(fundId)
            .type(TransactionType.OPENING.name())
            .amount(minimum)
            .date(LocalDateTime.now())
            .build();
    }

    public TransactionResponseDTO toDto(Transaction transaction) {
        return TransactionResponseDTO.builder()
            .id(transaction.getId())
            .fundId(transaction.getFundId())
            .type(transaction.getType())
            .amount(transaction.getAmount())
            .build();
    }

    public TransactionFundResponseDTO toDto(Transaction transaction, Fund fund) {
        return TransactionFundResponseDTO.builder()
            .transactionId(transaction.getId())
            .type(transaction.getType())
            .fundName(fund.getName())
            .fundMinimumAmount(fund.getMinimumAmount())
            .fundCategory(fund.getCategory())
            .build();
    }
}
