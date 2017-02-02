package com.example.data;

import javax.persistence.*;

/**
 * Created by jasonskipper on 2/2/17.
 */
@Entity
public class Owner {
    private String username;
    private String password;
    private String displayName;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    // multiple owners can own same animal
    private Animal myAnimal;

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

    public Animal getMyAnimal() {
        return myAnimal;
    }

    public void setMyAnimal(Animal myAnimal) {
        this.myAnimal = myAnimal;
    }
}
