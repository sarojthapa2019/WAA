package edu.mum.cs.waa.lab.ormrelationship_lab10.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
