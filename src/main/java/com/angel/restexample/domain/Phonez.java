package com.angel.restexample.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Phonez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;
    @Column(name = "cityCode")
    private String cityCode;
    @Column(name = "countryCode")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Userz user;
}
