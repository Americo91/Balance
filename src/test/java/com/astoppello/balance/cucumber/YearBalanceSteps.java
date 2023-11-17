package com.astoppello.balance.cucumber;

import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by @author stopp on 19/12/2021
 */
@ScenarioScope
@SpringBootTest
public class YearBalanceSteps {

    @Autowired
    YearBalanceClient yearBalanceClient;

    @Given("there are {int} yearBalances")
    public void thereAreYearBalances(int n) {
        assertThat(yearBalanceClient.getYearBalances()).hasSize(n);
    }

    @When("yearBalance year={int} is retrieved")
    public void yearbalanceYearIsRetrieved(int year) {
        YearBalanceResponse yb = yearBalanceClient.findYearBalanceByYear(year);
        assertThat(yb).isNotNull();
        assertThat(yb.getYear()).isEqualTo(year);
    }

    @When("yearBalance year={int} is not found")
    public void yearbalanceYearIsNotFound(int year) {
        assertThatThrownBy(() -> yearBalanceClient.findYearBalanceByYear(year))
                .isInstanceOf(HttpClientErrorException.class)
                .hasMessageContaining("404");
    }

    @When("yearBalance year={int} is retrieved by id")
    public void yearbalanceYearIsRetrievedById(int year) {
        YearBalanceResponse yb = yearBalanceClient.findYearBalanceByYear(year);
        assertThat(yb).isNotNull();
        YearBalanceResponse yearBalanceById = yearBalanceClient.findYearBalanceById(yb.getId());
        assertThat(yearBalanceById).isNotNull();
        assertThat(yearBalanceById).isEqualTo(yb);
    }
}
