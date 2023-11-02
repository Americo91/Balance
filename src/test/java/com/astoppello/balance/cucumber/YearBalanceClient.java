package com.astoppello.balance.cucumber;

import com.astoppello.balance.controllers.YearBalanceController;
import com.astoppello.balance.controllers.dto.YearBalancePost;
import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import io.cucumber.spring.ScenarioScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/** Created by @author stopp on 19/12/2021 */
@Component
@ScenarioScope
public class YearBalanceClient {

  private static final String HOST_URL = "http://localhost";
  protected RestTemplate restTemplate = new RestTemplate();
  @LocalServerPort
  private int port;
  Logger logger = LoggerFactory.getLogger(YearBalanceClient.class);

  YearBalanceResponse[] getYearBalances() {
    final String url = String.format("%s:%d%s/", HOST_URL, port, YearBalanceController.YEAR_BALANCE_PATH);
    logger.info("url: {}", url);
    ResponseEntity<YearBalanceResponse[]> response =
        restTemplate.getForEntity(url, YearBalanceResponse[].class);
    return response.getBody();
  }

  public YearBalanceResponse findYearBalanceByYear(int year) {
    final String url = String.format("%s:%d%s?year=%d", HOST_URL, port, YearBalanceController.YEAR_BALANCE_PATH, year);
    logger.info("url: {}", url);
    ResponseEntity<YearBalanceResponse> response =
            restTemplate.getForEntity(url, YearBalanceResponse.class);
    return response.getBody();
  }

  public YearBalanceResponse createYearBalance(YearBalancePost yearBalanceDTO) {
    final String url = String.format("%s:%d%s", HOST_URL, port, YearBalanceController.YEAR_BALANCE_PATH);
    ResponseEntity<YearBalanceResponse> response = restTemplate.postForEntity(url, yearBalanceDTO, YearBalanceResponse.class);
    return response.getBody();
  }
}
