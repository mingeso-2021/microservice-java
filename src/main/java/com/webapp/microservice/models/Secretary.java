package com.webapp.microservice.models;

public class Secretary {

    private Integer id;
    private String name;
    private String rut;
    private String email;
    private String phone;
    private int status;
    public Secretary(Integer id, String name, String rut,String email,String phone,int status) {
        this.id = id;
        this.name = name;
        this.rut = rut;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}