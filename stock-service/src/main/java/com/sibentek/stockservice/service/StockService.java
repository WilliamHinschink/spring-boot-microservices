package com.sibentek.stockservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 * Created by william on 16/03/2018.
 */
@AllArgsConstructor
public class StockService {

    public Stock getStockPrice(String quote) {
        try {
            return YahooFinance.get(quote);
        } catch (Exception e) {
            e.printStackTrace();
            return new Stock(quote);
        }
    }
}
