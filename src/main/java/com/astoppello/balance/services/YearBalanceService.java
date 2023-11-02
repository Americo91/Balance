package com.astoppello.balance.services;

import com.astoppello.balance.entities.YearBalance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface YearBalanceService {

    List<YearBalance> findAll();
    Optional<YearBalance> findById(UUID id);
    Optional<YearBalance> findByYear(Integer year);
    YearBalance save(YearBalance yb);

    YearBalance put(YearBalance yb, UUID uuid);
}
