package com.astoppello.balance.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal salary;
    private BigDecimal expenses;
    private BigDecimal incomes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBalance that)) return false;

        if (!getId().equals(that.getId())) return false;
        if (!getSalary().equals(that.getSalary())) return false;
        if (!getExpenses().equals(that.getExpenses())) return false;
        return getIncomes().equals(that.getIncomes());
    }

}
