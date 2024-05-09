package com.example.lab5_20206456.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Tecnicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int TechnicianID;

    @Column(name = "FirstName")
    @Size(min = 3, max = 100,message = "Solo se soportan entre 3 a 100 caractéres")
    @NotBlank
    private String firstName;

    @Column(name = "LastName")
    @Size(min = 3, max = 100,message = "Solo se soportan entre 3 a 100 caractéres")
    @NotBlank
    private String lastname;

    @Column(name = "Dni")
    @NotBlank
    private String dni;

    @Column(name = "Phone")
    @Size(max = 9,message = "Solo se soporta 9 dígitos")
    @NotBlank
    private String phone;

    @Column(name = "Age")
    @Digits(integer = 5, fraction = 0)
    @Positive(message = "Debe ser positivo")
    @NotNull
    private int age;
}
