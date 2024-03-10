package com.aubay.spaceships.Domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spaceship")
public class Spaceship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Spaceship() {
    }

    public Spaceship(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Spaceship (Long id, String name, String description) {
    	this.id = id;
    	this.name = name;
    	this.description = description;
    }

}
