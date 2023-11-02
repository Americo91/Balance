package com.astoppello.balance.services;

import com.astoppello.balance.entities.MonthBalance;

import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MonthBalanceService {
    List<MonthBalance> findAll();
    List<MonthBalance> findByMonth(Month month);
    Optional<MonthBalance> findById(UUID id);
    MonthBalance create(MonthBalance mb, UUID yearBalanceId);

    MonthBalance put(MonthBalance mb, UUID monthBalanceId);

}
