package com.sibentek.stockservice.contract;

import com.sibentek.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by william on 16/03/2018.
 */
@RestController
@RequestMapping("/rest/stock")
public class StockContract {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockService stockService;

    @GetMapping("/{username}")
    public List<Stock> getStock(@PathVariable("username") String username) {

        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:9033/rest/db/" + username,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});

        return quoteResponse
                .getBody()
                .stream()
                .map(quote -> stockService.getStockPrice(quote))
                .collect(Collectors.toList());
    }
}
