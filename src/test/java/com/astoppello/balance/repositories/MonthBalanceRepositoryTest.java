package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.MonthBalance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MonthBalanceRepositoryTest {

    @Autowired
    MonthBalanceRepository monthBalanceRepository;

    @Test
    void testRepo() {
        assertThat(monthBalanceRepository.findAll()).hasSize(0);
        MonthBalance mb = MonthBalance.builder()
                                      .month(Month.APRIL)
                                      .incomes(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .expenses(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .salary(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .build();
        MonthBalance saved = monthBalanceRepository.save(mb);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        assertThat(monthBalanceRepository.findAll()).hasSize(1);
        assertThat(monthBalanceRepository.findById(saved.getId()).orElse(null)).isEqualTo(saved);
    }

}