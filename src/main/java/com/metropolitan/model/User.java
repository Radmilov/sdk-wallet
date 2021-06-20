package com.metropolitan.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name="User")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite username.")
    private String username;
    

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message="Unesite email.")
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"

    )
    @NotEmpty(message="Unesite password.")
    private String password;

    @ManyToMany(
            cascade = {CascadeType.ALL, CascadeType.REMOVE}
    )
    @JoinTable(
            name = "sacuvani_walleti",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="wallet_id")
    )
    private Set<Wallet> walleti;

    public Student(String username, String prezusername, String email, String password, Set<Wallet> walleti) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.walleti = walleti;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Wallet> getWalleti() {
        return walleti;
    }

    public void setWalleti(Set<Wallet> walleti) {
        this.walleti = walleti;
    }

}
