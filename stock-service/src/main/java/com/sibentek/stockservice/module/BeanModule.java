package com.sibentek.stockservice.module;

import com.sibentek.stockservice.service.StockService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by william on 16/03/2018.
 */
@Configuration
public class BeanModule {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public StockService stockService(){
        return new StockService();
    }
}
