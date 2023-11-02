package com.astoppello.balance.services;

import com.astoppello.balance.entities.MonthBalance;
import com.astoppello.balance.entities.YearBalance;
import com.astoppello.balance.repositories.MonthBalanceRepository;
import com.astoppello.balance.repositories.YearBalanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    private final YearBalanceRepository yearBalanceRepository;

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

    @Override
    public MonthBalance create(MonthBalance mb, UUID yearBalanceId) {
        YearBalance yearBalance = yearBalanceRepository.findById(yearBalanceId)
                                                       .orElseThrow(EntityNotFoundException::new);
        mb.setYearBalance(yearBalance);
        return monthBalanceRepository.save(mb);
    }

    @Override
    public MonthBalance put(MonthBalance mb, UUID monthBalanceId) {
        MonthBalance mbDb = findById(monthBalanceId).orElseThrow(EntityNotFoundException::new);
        mbDb.setMonth(mb.getMonth());
        mbDb.setExpenses(mb.getExpenses());
        mbDb.setIncomes(mb.getIncomes());
        mbDb.setSalary(mb.getSalary());
        return mbDb;
    }


}
