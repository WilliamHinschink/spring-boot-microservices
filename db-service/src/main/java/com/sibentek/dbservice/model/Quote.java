package com.sibentek.dbservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "quotes", catalog = "test")
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "quote")
    private String quote;

    public Quote(String username, String quote) {
        this.username = username;
        this.quote = quote;
    }
}
