package com.astoppello.balance.cucumber;

import com.astoppello.balance.controllers.MonthBalanceController;
import com.astoppello.balance.controllers.YearBalanceController;
import com.astoppello.balance.controllers.dto.MonthBalanceResponse;
import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import io.cucumber.spring.ScenarioScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ScenarioScope
public class MonthBalanceClient {
    private static final String HOST_URL = "http://localhost";
    protected RestTemplate restTemplate = new RestTemplate();
    @LocalServerPort
    private int port;

    MonthBalanceResponse[] getMonthBalances() {
        final String url = String.format("%s:%d%s/", HOST_URL, port, MonthBalanceController.MONTH_BALANCE_PATH);
        ResponseEntity<MonthBalanceResponse[]> response =
                restTemplate.getForEntity(url, MonthBalanceResponse[].class);
        return response.getBody();
    }


    MonthBalanceResponse[] getMonthBalancesByMonth(String month) {
        final String url = String.format("%s:%d%s?month=%s", HOST_URL, port,
                                         MonthBalanceController.MONTH_BALANCE_PATH, month);
        ResponseEntity<MonthBalanceResponse[]> response =
                restTemplate.getForEntity(url, MonthBalanceResponse[].class);
        return response.getBody();
    }
}
