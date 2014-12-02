package com.searhiy.rest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by serhii on 02.12.14.
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public @Data class Transaction {

    @JsonProperty
    private Long fromCreditCard;
    @JsonProperty
    private Long toCreditCard;
    @JsonProperty
    private double amount;
}
