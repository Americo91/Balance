package com.astoppello.balance.services;

import com.astoppello.balance.entities.YearBalance;
import com.astoppello.balance.repositories.YearBalanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class YearBalanceServiceImpl implements YearBalanceService {

    private final YearBalanceRepository yearBalanceRepository;

    @Override
    public List<YearBalance> findAll() {
        return yearBalanceRepository.findAll();
    }

    @Override
    public Optional<YearBalance> findById(UUID id) {
        return yearBalanceRepository.findById(id);
    }

    @Override
    public Optional<YearBalance> findByYear(Integer year) {
        return yearBalanceRepository.findByYear(year);
    }

    @Override
    public YearBalance save(YearBalance yb) {
        return yearBalanceRepository.save(yb);
    }

    @Override
    public YearBalance put(YearBalance yb, UUID uuid) {
        YearBalance yearBalance = findById(uuid).orElseThrow(EntityNotFoundException::new);
        yearBalance.setYear(yb.getYear());
        return yearBalanceRepository.save(yearBalance);
    }
}
