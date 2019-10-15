package edu.mum.cs.waa.lab.ormrelationship_lab10.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String zipCode;
    private String state;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
