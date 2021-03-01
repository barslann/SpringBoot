package com.coderman.hibernateentityrelationsexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Date dob;

//    @ManyToOne
//    @JoinColumn(name = "type_id")
//    private PetType petType;
//
//    @ManyToOne
//    private Owner owner;

}
