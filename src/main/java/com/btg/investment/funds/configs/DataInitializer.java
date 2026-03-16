package com.btg.investment.funds.configs;


import com.btg.investment.funds.models.Fund;
import com.btg.investment.funds.repositories.FundRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initFunds(FundRepository fundRepository) {
        return args -> {

            if (fundRepository.count() == 0) {

                fundRepository.save(Fund.builder()
                    .name("FPV_BTG_PACTUAL_RECAUDADORA")
                    .minimumAmount(75000.0)
                    .category("FPV")
                    .build());

                fundRepository.save(Fund.builder()
                    .name("FPV_BTG_PACTUAL_ECOPETROL")
                    .minimumAmount(125000.0)
                    .category("FPV")
                    .build());

                fundRepository.save(Fund.builder()
                    .name("DEUDAPRIVADA")
                    .minimumAmount(50000.0)
                    .category("FIC")
                    .build());

                fundRepository.save(Fund.builder()
                    .name("FDO-ACCIONES")
                    .minimumAmount(250000.0)
                    .category("FIC")
                    .build());

                fundRepository.save(Fund.builder()
                    .name("FPV_BTG_PACTUAL_DINAMICA")
                    .minimumAmount(100000.0)
                    .category("FPV")
                    .build());
            }

        };
    }
}
