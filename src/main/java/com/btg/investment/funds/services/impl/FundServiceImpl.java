package com.btg.investment.funds.services.impl;


import com.btg.investment.funds.domain.dtos.response.FundResponseDTO;
import com.btg.investment.funds.exceptions.ResourceNotFoundException;
import com.btg.investment.funds.mappers.FundMapper;
import com.btg.investment.funds.models.Fund;
import com.btg.investment.funds.repositories.FundRepository;
import com.btg.investment.funds.services.IFundService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundServiceImpl implements IFundService {

    private final FundRepository fundRepository;
    private final FundMapper fundMapper;

    public FundServiceImpl(FundRepository fundRepository, FundMapper fundMapper) {
        this.fundRepository = fundRepository;
        this.fundMapper = fundMapper;
    }

    @Override
    public List<FundResponseDTO> getAllFunds() {
        return fundRepository.findAll().stream()
            .map(fundMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public FundResponseDTO getFundById(String id) {
        Fund fund = fundRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontró el fund con id: " + id));

        return fundMapper.toDto(fund);
    }
}
