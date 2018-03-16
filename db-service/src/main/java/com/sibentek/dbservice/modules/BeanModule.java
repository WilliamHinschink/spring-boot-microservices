package com.sibentek.dbservice.modules;

import com.sibentek.dbservice.repository.QuotesRepository;
import com.sibentek.dbservice.service.QuoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModule {

    @Bean
    public QuoteService quoteService(QuotesRepository quotesRepository){
        return new QuoteService(quotesRepository);
    }
}
