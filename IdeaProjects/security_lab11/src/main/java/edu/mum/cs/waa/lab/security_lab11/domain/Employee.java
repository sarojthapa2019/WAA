package edu.mum.cs.waa.lab.security_lab11.domain;

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
    @OneToOne (cascade = CascadeType.ALL, mappedBy = "employee")
    private Address address;
    private String username;
    private String password;
    private int active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_role")
    private Role role;
}
