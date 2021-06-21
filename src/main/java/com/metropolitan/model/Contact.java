package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "ime",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite ime.")
    private String ime;

    @Column(
            name = "public_key",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite ime.")
    private String publicKey;

    public Contact(String publicKey, String ime) {
        this.publicKey = publicKey;
        this.ime = ime;
    }

    public Contact() {
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}