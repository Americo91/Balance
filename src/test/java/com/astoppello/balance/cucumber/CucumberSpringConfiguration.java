package com.astoppello.balance.cucumber;

import com.astoppello.balance.BalanceApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BalanceApplication.class, properties = {})
public class CucumberSpringConfiguration {
}
