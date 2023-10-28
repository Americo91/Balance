package com.astoppello.balance.bootstrap;

import com.astoppello.balance.entities.YearBalance;
import com.astoppello.balance.repositories.YearBalanceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final YearBalanceRepository yearBalanceRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        yearBalanceRepository.save(YearBalance.builder().year(2021).id(UUID.randomUUID()).build());
    }
}
