package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "poruka",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite poruku.")
    private String poruka;

    public Note(String poruka) {
        this.poruka = poruka;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
