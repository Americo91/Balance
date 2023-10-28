package com.astoppello.balance.repositories;

import com.astoppello.balance.entities.YearBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YearBalanceRepository extends JpaRepository<YearBalance, UUID> {
    Optional<YearBalance> findByYear(Integer year);
}
