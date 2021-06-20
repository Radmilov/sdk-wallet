package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "public_key"
    )
    private Long publicKey;

    @Column(
            name = "ime",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite ime.")
    private String ime;

    public Contact(Long publicKey, String ime) {
        this.publicKey = publicKey;
        this.ime = ime;
    }

    public Contact() {
    }

    public Long getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(Long publicKey) {
        this.publicKey = publicKey;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}