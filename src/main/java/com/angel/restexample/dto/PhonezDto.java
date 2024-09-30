package com.angel.restexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.angel.restexample.domain.Phonez}
 */
@Value
public class PhonezDto implements Serializable {

    String number;

    @JsonProperty("citycode")
    String cityCode;
    @JsonProperty("countrycode")
    String countryCode;
}