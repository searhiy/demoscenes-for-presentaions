package com.searhiy.rest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 01.12.14.
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public @Data class Account {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonIgnore
    private List<CreditCard> creditCards = new ArrayList<>();
}
