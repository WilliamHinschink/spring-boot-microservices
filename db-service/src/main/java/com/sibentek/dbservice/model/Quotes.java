package com.sibentek.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Quotes {

    private String username;
    private List<String> quotes;
}
