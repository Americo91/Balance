package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.MonthBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonthBalanceRepository extends JpaRepository<MonthBalance, UUID> {
}
