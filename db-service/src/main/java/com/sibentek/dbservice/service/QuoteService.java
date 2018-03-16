package com.sibentek.dbservice.service;

import com.sibentek.dbservice.model.Quote;
import com.sibentek.dbservice.model.Quotes;
import com.sibentek.dbservice.repository.QuotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuoteService {

    private QuotesRepository quotesRepository;

    public List<String> getQuotes(String username) {
        return quotesRepository.findByUsername(username)
                .stream()
                .map(Quote::getUsername)
                .collect(Collectors.toList());
    }

    public void save(Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUsername(), quote))
                .forEach(quote -> quotesRepository.save(quote));
    }

}
