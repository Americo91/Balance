package com.astoppello.balance.cucumber;

import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by @author stopp on 19/12/2021
 */
@ScenarioScope
@SpringBootTest
public class MonthBalanceSteps {

    @Autowired
    MonthBalanceClient monthBalanceClient;

    @Given("there are {int} monthBalance")
    public void thereAreMonthBalance(int n) {
        assertThat(monthBalanceClient.getMonthBalances()).hasSize(n);
    }

    @Given("there are {int} monthBalance with Month {string}")
    public void thereAreMonthBalanceWithMonth(int n, String month) {
        Month m = Month.valueOf(month);
        assertThat(monthBalanceClient.getMonthBalancesByMonth(month)).hasSize(n);
    }
}
