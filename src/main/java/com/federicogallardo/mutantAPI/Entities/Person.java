package com.federicogallardo.mutantAPI.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    private String lastname;
    private String address;
    private String dni;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean mutant;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> dna;

    public int getId() {
        return id;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Person() {
    }

    public Person(String name, String lastname, String address, String dni, boolean mutant, List<String> dna) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.mutant = mutant;
        this.dna = dna;
    }
    
}