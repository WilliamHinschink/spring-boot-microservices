package com.sibentek.dbservice.contract;


import com.sibentek.dbservice.model.Quotes;
import com.sibentek.dbservice.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author WILLIAM
 * @since 15/02/2016
 */
@RestController
@RequestMapping("/rest/db")
public class DbServiceContract {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") String username) {
        return quoteService.getQuotes(username);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody Quotes quotes) {
        quoteService.save(quotes);
        return quoteService.getQuotes(quotes.getUsername());
    }
}
