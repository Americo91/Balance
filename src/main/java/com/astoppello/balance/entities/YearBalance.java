package com.astoppello.balance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class YearBalance extends BaseBalance{

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
