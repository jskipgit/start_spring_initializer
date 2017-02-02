package com.example.data;

import javax.persistence.*;

/**
 * Created by jasonskipper on 2/2/17.
 */
@Entity
public class Animal {
    private String name;
    private String className;
    private String kingdomName;
    private String color;
    private String addedValue;

    @ManyToOne
    // animal can have a reference to it's owner
    private OwnerWithManyAnimals owner;


    @Id @GeneratedValue
    private long id;

    public String getAddedValue() {
        return addedValue;
    }

    public OwnerWithManyAnimals getOwner() {
        return owner;
    }

    public void setOwner(OwnerWithManyAnimals owner) {
        this.owner = owner;
    }

    public void setAddedValue(String addedValue) {
        this.addedValue = addedValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public void setKingdomName(String kingdomName) {
        this.kingdomName = kingdomName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
