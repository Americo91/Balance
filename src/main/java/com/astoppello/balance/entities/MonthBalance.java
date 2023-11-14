package com.astoppello.balance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Entity
public class MonthBalance extends BaseBalance {

    @NotNull
    private Month month;

    @ManyToOne()
    private YearBalance yearBalance;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthBalance that)) return false;
        if (!super.equals(o)) return false;

        return getMonth() != null ? getMonth().equals(that.getMonth()) : that.getMonth() == null;
    }
}
