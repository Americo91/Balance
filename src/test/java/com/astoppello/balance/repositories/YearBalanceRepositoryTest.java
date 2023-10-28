package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.YearBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class YearBalanceRepositoryTest {

    @Autowired
    YearBalanceRepository yearBalanceRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testRepo() {
        assertThat(yearBalanceRepository.findAll()).hasSize(1);
        YearBalance yb = YearBalance.builder().year(2020)
                                    .incomes(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                    .expenses(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                    .salary(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                    .build();

        YearBalance savedYb = yearBalanceRepository.save(yb);
        assertThat(savedYb.getId()).isNotNull();
        assertThat(yearBalanceRepository.findAll()).hasSize(2);
        assertThat(yearBalanceRepository.findById(savedYb.getId()).orElse(null)).isEqualTo(savedYb);
    }
}