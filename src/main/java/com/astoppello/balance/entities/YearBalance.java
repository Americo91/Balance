package com.astoppello.balance.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class YearBalance extends BaseBalance {

    @NotNull
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YearBalance that)) return false;
        if (!super.equals(o)) return false;

        return getYear() != null ? getYear().equals(that.getYear()) : that.getYear() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        return result;
    }
}
