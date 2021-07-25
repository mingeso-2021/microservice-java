package com.webapp.microservice.models;

public class Secretary {

    private Interger id;
    private String name;
    private String rut;
    private String email;
    private String phone;


    public Interger getId() {
        return this.id;
    }

    public void setId(Interger id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}