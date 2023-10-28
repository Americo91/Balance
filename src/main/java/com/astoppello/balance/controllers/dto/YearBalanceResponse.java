package com.astoppello.balance.controllers.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class YearBalanceResponse extends YearBalancePost {
    private UUID id;
    private BigDecimal salary;
    private BigDecimal expenses;
    private BigDecimal incomes;
}
