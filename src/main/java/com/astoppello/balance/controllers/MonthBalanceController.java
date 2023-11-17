package com.astoppello.balance.controllers;

import com.astoppello.balance.controllers.dto.MonthBalanceResponse;
import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import com.astoppello.balance.mappers.MonthBalanceMapper;
import com.astoppello.balance.mappers.YearBalanceMapper;
import com.astoppello.balance.services.MonthBalanceService;
import com.astoppello.balance.services.YearBalanceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MonthBalanceController {

    public static final String MONTH_BALANCE_PATH = "/month-balances";
    public static final String MONTH_BALANCE_PATH_ID = MONTH_BALANCE_PATH+"/{monthBalanceId}";

    private final MonthBalanceService service;
    private final MonthBalanceMapper mapper;

    @GetMapping(MONTH_BALANCE_PATH+"/")
    public List<MonthBalanceResponse> findAll() {
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(MONTH_BALANCE_PATH)
    public List<MonthBalanceResponse> findByMonth(@RequestParam("month") String month) {
        return service.findByMonth(Month.valueOf(month)).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(MONTH_BALANCE_PATH_ID)
    public MonthBalanceResponse findById(@PathVariable UUID monthBalanceId) {
        return service.findById(monthBalanceId).map(mapper::toDto).orElseThrow(EntityNotFoundException::new);
    }
}
