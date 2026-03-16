package com.btg.investment.funds.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "funds")
public class Fund {

    @Id
    private String id;
    private String name;
    private Double minimumAmount;
    private String category;

    public static class FundBuilder {
        private String name;
        private Double minimumAmount;
        private String category;

        public FundBuilder name(String name) { this.name = name; return this; }
        public FundBuilder minimumAmount(Double amount) { this.minimumAmount = amount; return this; }
        public FundBuilder category(String category) { this.category = category; return this; }
        public Fund build() {
            Fund fund = new Fund();
            fund.name = this.name;
            fund.minimumAmount = this.minimumAmount;
            fund.category = this.category;
            return fund;
        }
    }
    public static FundBuilder builder() { return new FundBuilder(); }
}
