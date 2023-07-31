package com.example.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;



@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Person {

    @NotNull
    protected String firstname;
    @NotNull
    protected String lastname;
    @Column(unique = true,nullable = true)
    protected String email;
    @Column(unique = true,nullable = false)
    protected  String username;

    @NonNull
    @Column(unique = true, nullable = false)
    protected String phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    protected Long id;
}
