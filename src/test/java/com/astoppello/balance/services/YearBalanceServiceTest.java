package com.astoppello.balance.services;

import com.astoppello.balance.entities.YearBalance;
import com.astoppello.balance.repositories.YearBalanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YearBalanceServiceTest {

    @Autowired
    YearBalanceRepository yearBalanceRepository;
    @Autowired
    YearBalanceService service;

    @BeforeEach
    void setUp() {
        service = new YearBalanceServiceImpl(yearBalanceRepository);
    }

    @Test
    void findAll() {
        assertThat(service.findAll()).hasSize(1);
    }

    @Test
    void findByYearAndId() {
        Optional<YearBalance> byYear = service.findByYear(2021);
        assertThat(byYear).isPresent();
        YearBalance yearBalance = byYear.get();
        assertThat(yearBalance).isNotNull();
        assertThat(yearBalance.getYear()).isEqualTo(2021);
        assertThat(yearBalance.getId()).isNotNull();

        assertThat(service.findById(yearBalance.getId())).isPresent();
    }
}