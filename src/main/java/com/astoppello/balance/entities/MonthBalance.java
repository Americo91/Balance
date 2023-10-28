package com.astoppello.balance.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Month;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class MonthBalance extends BaseBalance {

    @NotNull
    private Month month;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthBalance that)) return false;
        if (!super.equals(o)) return false;

        return getMonth() != null ? getMonth().equals(that.getMonth()) : that.getMonth() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getMonth() != null ? getMonth().hashCode() : 0);
        return result;
    }
}
