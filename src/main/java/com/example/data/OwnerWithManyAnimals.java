package com.example.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jasonskipper on 2/2/17.
 */
@Entity
public class OwnerWithManyAnimals {
    private String username;
    private String password;
    private String displayName;

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.EAGER)
    // one owner can own many animals
    private List<Animal> myAnimals;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Animal> getMyAnimals() {
        return myAnimals;
    }

    public void setMyAnimals(List<Animal> myAnimals) {
        this.myAnimals = myAnimals;
    }
}
