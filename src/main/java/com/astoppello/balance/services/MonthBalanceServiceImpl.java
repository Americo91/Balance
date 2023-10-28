package com.astoppello.balance.services;

import com.astoppello.balance.entities.MonthBalance;
import com.astoppello.balance.repositories.MonthBalanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MonthBalanceServiceImpl implements MonthBalanceService {

    private final MonthBalanceRepository monthBalanceRepository;

    @Override
    public List<MonthBalance> findAll() {
        return monthBalanceRepository.findAll();
    }

    @Override
    public List<MonthBalance> findByMonth(Month month) {
        return monthBalanceRepository.findAllByMonth(month);
    }

    @Override
    public Optional<MonthBalance> findById(UUID id) {
        return monthBalanceRepository.findById(id);
    }
}
