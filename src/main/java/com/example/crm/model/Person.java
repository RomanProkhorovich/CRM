package com.example.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;




@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Entity
public abstract class Person {

    @NotNull
    protected String firstname;
    @NotNull
    protected String lastname;
    @NotNull
    @Column(unique = true,nullable = false)
    protected String email;
    @NotNull
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
