package com.astoppello.balance.mappers;

import com.astoppello.balance.controllers.dto.MonthBalancePost;
import com.astoppello.balance.controllers.dto.MonthBalanceResponse;
import com.astoppello.balance.entities.MonthBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class MonthBalanceMapperTest {

    MonthBalanceMapper mapper;
    Month month = Month.APRIL;
    BigDecimal value = new BigDecimal("200.00");

    @BeforeEach
    void setUp() {
        mapper = new MonthBalanceMapperImpl();
    }

    @Test
    void toEntity() {
        MonthBalancePost post = MonthBalancePost.builder()
                                                .month(month)
                                                .incomes(value)
                                                .expenses(value)
                                                .salary(value)
                                                .build();
        MonthBalance entity = mapper.toEntity(post);
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isNull();
        assertThat(entity.getMonth()).isEqualTo(month);
        assertThat(entity.getSalary()).isEqualTo(value);
        assertThat(entity.getExpenses()).isEqualTo(value);
        assertThat(entity.getIncomes()).isEqualTo(value);
    }

    @Test
    void toDto() {
        UUID id = UUID.randomUUID();
        MonthBalance entity = MonthBalance.builder()
                                          .id(id)
                                          .month(month)
                                          .incomes(value)
                                          .expenses(value)
                                          .salary(value)
                                          .build();
        MonthBalanceResponse dto = mapper.toDto(entity);
        assertThat(dto).isNotNull();
        assertThat(entity.getId()).isEqualTo(id);
        assertThat(entity.getMonth()).isEqualTo(month);
        assertThat(entity.getSalary()).isEqualTo(value);
        assertThat(entity.getExpenses()).isEqualTo(value);
        assertThat(entity.getIncomes()).isEqualTo(value);
    }
}