package com.angel.restexample.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "USERZ")
public class Userz {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;
    private String email;
    private String password;

    @CreationTimestamp
    private Date created;
    private Date lastLogin;
    @UpdateTimestamp
    private Date modified;

    private boolean isActive;
    private String token;

}
