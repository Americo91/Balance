package com.astoppello.balance.services;

import com.astoppello.balance.entities.MonthBalance;
import com.astoppello.balance.repositories.MonthBalanceRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MonthBalanceServiceTest {

    @Autowired
    MonthBalanceRepository monthBalanceRepository;

    MonthBalanceService service;
    private UUID id;
    private BigDecimal value = new BigDecimal("201.00");

    @BeforeAll
    void setUp() {
        service = new MonthBalanceServiceImpl(monthBalanceRepository);
        MonthBalance mb = MonthBalance.builder()
                                      .month(Month.APRIL)
                                      .salary(value)
                                      .expenses(value)
                                      .incomes(value)
                                      .build();
        MonthBalance saved = monthBalanceRepository.save(mb);
        id = saved.getId();
    }

    @AfterAll
    void cleanUp() {
        monthBalanceRepository.deleteById(id);
    }

    @Test
    void findAll() {
        assertThat(service.findAll()).hasSize(1);
    }

    @Test
    void findByMonth() {
        assertThat(service.findByMonth(Month.APRIL)).hasSize(1);
        assertThat(service.findByMonth(Month.SEPTEMBER)).hasSize(0);
    }

    @Test
    void findById() {
        Optional<MonthBalance> byId = service.findById(id);
        assertThat(byId).isPresent();
        MonthBalance mb = byId.get();
        assertThat(mb).isNotNull();
        assertThat(mb.getId()).isEqualTo(id);
        assertThat(mb.getMonth()).isEqualTo(Month.APRIL);
        assertThat(mb.getIncomes()).isEqualTo(value);
        assertThat(mb.getSalary()).isEqualTo(value);
        assertThat(mb.getExpenses()).isEqualTo(value);
    }
}