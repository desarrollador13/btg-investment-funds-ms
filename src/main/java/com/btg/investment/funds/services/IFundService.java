package com.btg.investment.funds.services;

import com.btg.investment.funds.domain.dtos.response.FundResponseDTO;

import java.util.List;

public interface IFundService {
    List<FundResponseDTO> getAllFunds();
    FundResponseDTO getFundById(String id);
}
