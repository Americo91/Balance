package com.astoppello.balance.mappers;

import com.astoppello.balance.controllers.dto.YearBalancePost;
import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import com.astoppello.balance.entities.YearBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class YearBalanceMapperTest {

    YearBalanceMapper mapper;
    int year = 2020;

    @BeforeEach
    void setUp() {
        mapper = new YearBalanceMapperImpl();
    }

    @Test
    void toEntity() {
        YearBalancePost post = YearBalancePost.builder().year(year).build();
        YearBalance entity = mapper.toEntity(post);
        assertThat(entity).isNotNull();
        assertThat(entity.getYear()).isEqualTo(year);
        assertThat(entity.getId()).isNull();
        assertThat(entity.getSalary()).isNull();
        assertThat(entity.getIncomes()).isNull();
        assertThat(entity.getExpenses()).isNull();
    }

    @Test
    void toDto() {
        UUID id = UUID.randomUUID();
        BigDecimal value = new BigDecimal("200.00");
        YearBalance entity = YearBalance.builder()
                                        .id(id)
                                        .year(year)
                                        .expenses(value)
                                        .incomes(value)
                                        .salary(value)
                                        .build();
        YearBalanceResponse dto = mapper.toDto(entity);
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getYear()).isEqualTo(year);
        assertThat(dto.getSalary()).isEqualTo(value);
        assertThat(dto.getIncomes()).isEqualTo(value);
        assertThat(dto.getExpenses()).isEqualTo(value);
    }
}