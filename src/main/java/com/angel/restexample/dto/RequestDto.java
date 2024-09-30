package com.angel.restexample.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.angel.restexample.domain.Userz}
 */
@Value
public class RequestDto implements Serializable {

    String name;
    String email;
    String password;
    List<PhonezDto> phones;
}