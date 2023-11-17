package com.astoppello.balance.controllers;

import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import com.astoppello.balance.mappers.YearBalanceMapper;
import com.astoppello.balance.services.YearBalanceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class YearBalanceController {

    public static final String YEAR_BALANCE_PATH = "/year-balances";
    public static final String YEAR_BALANCE_PATH_ID = YEAR_BALANCE_PATH+"/{yearBalanceId}";

    private final YearBalanceService service;
    private final YearBalanceMapper mapper;

    @GetMapping(YEAR_BALANCE_PATH+"/")
    public List<YearBalanceResponse> findAll() {
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(YEAR_BALANCE_PATH)
    public YearBalanceResponse findByYear(@RequestParam("year") Integer year) {
        return service.findByYear(year).map(mapper::toDto).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping(YEAR_BALANCE_PATH_ID)
    public YearBalanceResponse findById(@PathVariable UUID yearBalanceId) {
        return service.findById(yearBalanceId).map(mapper::toDto).orElseThrow(EntityNotFoundException::new);
    }
}
