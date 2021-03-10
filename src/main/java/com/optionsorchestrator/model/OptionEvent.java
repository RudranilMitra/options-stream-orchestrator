package com.optionsorchestrator.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OptionEvent {
    private String symbol;
    private String status;
    private Object underlying;
    private String strategy;
    private BigDecimal interval;
    private Boolean isDelayed;
    private Boolean isIndex;
    private BigDecimal interestRate;
    private BigDecimal underlyingPrice;
    private BigDecimal volatility;
    private BigDecimal daysToExpiration;
    private Integer numberOfContracts;
    private List<StrikePrice> putStrikePrices;
    private List<StrikePrice> callStrikePrices;
}