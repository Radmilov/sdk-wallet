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

    public Network(String adresa, String ime) {
        this.adresa = adresa;
        this.ime = ime;
    }

    public Network() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
