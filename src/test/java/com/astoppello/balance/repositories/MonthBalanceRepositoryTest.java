package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.MonthBalance;
import com.astoppello.balance.entities.YearBalance;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MonthBalanceRepositoryTest {

    @Autowired
    MonthBalanceRepository monthBalanceRepository;

    @Autowired
    YearBalanceRepository yearBalanceRepository;
    private YearBalance yb;

    @BeforeEach
    void setUp() {
        yb = yearBalanceRepository.findAll().get(0);
    }
    
    @Transactional
    @Test
    void testRepo() {
        assertThat(yearBalanceRepository.findAll()).hasSize(1);
        assertThat(monthBalanceRepository.findAll()).hasSize(0);
        MonthBalance mb = MonthBalance.builder()
                                      .month(Month.APRIL)
                                      .incomes(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .expenses(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .salary(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN))
                                      .yearBalance(yb)
                                      .build();
        MonthBalance saved = monthBalanceRepository.save(mb);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getYearBalance()).isEqualTo(yb);

        assertThat(monthBalanceRepository.findAll()).hasSize(1);
        assertThat(monthBalanceRepository.findById(saved.getId()).orElse(null)).isEqualTo(saved);

        assertThat(monthBalanceRepository.findAllByYearBalance_Year(yb.getYear())).hasSize(1);
        assertThat(monthBalanceRepository.findAllByYearBalance_Year(1999)).hasSize(0);

        monthBalanceRepository.deleteById(saved.getId());
        assertThat(monthBalanceRepository.findAll()).hasSize(0);
    }

}