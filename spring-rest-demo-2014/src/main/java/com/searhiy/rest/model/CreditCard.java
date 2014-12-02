package com.searhiy.rest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by serhii on 01.12.14.
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public @Data class CreditCard {

    @JsonProperty
    private Long cardNumber;
    @JsonIgnore
    private int PIN;
    @JsonProperty
    private CardStatus cardStatus;
    @JsonProperty
    private double remnant;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "PIN", "cardStatus", "remnant");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
