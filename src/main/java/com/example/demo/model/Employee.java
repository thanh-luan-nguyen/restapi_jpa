package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity // specifies that this Java class is mapped to the database table.
@Table(name = "employee_01") // specifies which particular table this class is mapped to.
@Data
public class Employee {

    @Id // specifies primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies the strategy that will be used for generating primary keys.
    @Column(name="id") // @Column on each Java instance variable allows defining a set of properties like name, length etc.
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email_id")
    private String emailId;
}