package com.angel.restexample.dto;

import com.angel.restexample.domain.Userz;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * DTO for {@link Userz}
 */

@Data
public class ResponseDto implements Serializable {

    String name;
    String id;
    Date created;
    Date lastLogin;
    Date modified;
    boolean isActive;
    String token;
}