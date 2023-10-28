package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.YearBalance;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YearBalanceRepositoryTest {

    @Autowired
    YearBalanceRepository yearBalanceRepository;
    private UUID id;

    @AfterAll
    void cleanUp() {
        yearBalanceRepository.deleteById(id);
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
        id = savedYb.getId();
        assertThat(id).isNotNull();
        assertThat(yearBalanceRepository.findAll()).hasSize(2);
        assertThat(yearBalanceRepository.findById(id).orElse(null)).isEqualTo(savedYb);
    }

    @Test
    void testFindByYear() {
        Optional<YearBalance> byYear = yearBalanceRepository.findByYear(2021);
        assertThat(byYear).isPresent();
        YearBalance yb = byYear.get();
        assertThat(yb.getYear()).isEqualTo(2021);
    }
}