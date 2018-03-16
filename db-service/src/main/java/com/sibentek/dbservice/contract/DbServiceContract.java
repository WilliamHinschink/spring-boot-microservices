package com.sibentek.dbservice.contract;


import com.sibentek.dbservice.model.Quotes;
import com.sibentek.dbservice.service.QuoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * @author WILLIAM
 * @since 15/02/2016
 */
@RestController
@RequestMapping("/rest/db")
@Api(value = "db-service",
        description = "Simple service example with spring boot",
        produces = MediaType.APPLICATION_JSON,
        consumes = MediaType.APPLICATION_JSON)
public class DbServiceContract {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/{username}")
    @ApiOperation(value = "List of quotes by username")
    public List<String> getQuotes(@PathVariable("username") @Valid @NotNull String username) {
        return quoteService.getQuotes(username);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Addd quotes")
    public List<String> add(@RequestBody @Valid @NotNull @NotEmpty Quotes quotes) {
        quoteService.save(quotes);
        return quoteService.getQuotes(quotes.getUsername());
    }

    @PostMapping("/delete/{username}")
    @ApiOperation(value = "Delete quotes by username")
    public List<String> delete(@PathVariable("username") @Valid @NotNull String username) {
        return quoteService.delete(username);
    }
}
