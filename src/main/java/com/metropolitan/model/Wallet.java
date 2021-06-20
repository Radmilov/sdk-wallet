package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "public_key",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite public key.")
    private String publicKey;
    @Column(
            name = "private_key",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite private key.")
    private String privateKey;



}
