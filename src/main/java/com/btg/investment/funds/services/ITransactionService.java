package com.btg.investment.funds.services;

import com.btg.investment.funds.domain.dtos.response.TransactionFundResponseDTO;
import com.btg.investment.funds.domain.dtos.response.TransactionResponseDTO;

import java.util.List;

public interface ITransactionService {
    List<TransactionFundResponseDTO> getTransactionHistory(String clientId);
}
