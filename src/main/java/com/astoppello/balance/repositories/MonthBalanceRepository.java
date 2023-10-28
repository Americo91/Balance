package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.MonthBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.util.List;
import java.util.UUID;

public interface MonthBalanceRepository extends JpaRepository<MonthBalance, UUID> {
    List<MonthBalance> findAllByMonth(Month month);
}
