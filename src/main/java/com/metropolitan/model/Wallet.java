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
    @Column(
            name = "alias",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite alias.")
    private String alias;

    public Wallet(String publicKey, String privateKey, String alias) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.alias = alias;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
