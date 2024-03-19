package com.aubay.spaceships.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spaceship")
public class Spaceship implements Serializable {

    private static final long serialVersionUID = -4736917129237666101L;

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
    
    @Override
	public String toString() {
		return "Spaceship [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
