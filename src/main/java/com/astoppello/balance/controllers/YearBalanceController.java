package com.astoppello.balance.controllers;

import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(YearBalanceController.YEAR_BALANCE_PATH)
@RequiredArgsConstructor
public class YearBalanceController {

    public static final String YEAR_BALANCE_PATH = "/year-balances";
    public static final String YEAR_BALANCE_PATH_ID = YEAR_BALANCE_PATH+"/{yearBalanceId}";
}
