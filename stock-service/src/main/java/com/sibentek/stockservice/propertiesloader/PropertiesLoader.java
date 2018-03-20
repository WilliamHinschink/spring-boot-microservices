package com.sibentek.stockservice.propertiesloader;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PropertiesLoader {

    @Value("server.service-url")
    private String restDb;

}
