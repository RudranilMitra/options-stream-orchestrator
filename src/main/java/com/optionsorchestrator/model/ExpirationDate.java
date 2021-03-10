package com.optionsorchestrator.model;


import lombok.*;

import java.util.LinkedHashMap;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ExpirationDate {
    private LinkedHashMap<String,StrikePrice> strikePriceKey;
}