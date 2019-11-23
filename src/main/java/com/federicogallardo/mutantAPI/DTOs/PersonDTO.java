package com.federicogallardo.mutantAPI.DTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDTO {
    private int id;

    private String name;
    private String lastname;
    private String address;
    private String dni;

    @JsonProperty(required = false)
    private boolean mutant;
    
    private List<String> dna;

    public PersonDTO() {
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
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

    public PersonDTO(String name, String lastname, String address, String dni, boolean mutant, List<String> dna) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.mutant = mutant;
        this.dna = dna;
    }
    
}