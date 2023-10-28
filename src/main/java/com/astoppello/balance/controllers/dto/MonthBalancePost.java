package com.astoppello.balance.controllers.dto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Month;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class MonthBalancePost {

    @Nonnull
    private Month month;
    @Nonnull
    private BigDecimal salary;
    @Nonnull
    private BigDecimal expenses;
    @Nonnull
    private BigDecimal incomes;


}
