package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Network")
public class Network {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "adresa",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite adresu mreze.")
    private String adresa;
    @Column(
            name = "ime",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite ime mreze.")
    private String ime;
}
