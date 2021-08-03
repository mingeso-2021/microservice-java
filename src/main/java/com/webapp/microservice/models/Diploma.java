package com.webapp.microservice.models;

public class Diploma {
    
    private Interger id;
    private String name;

    public Interger getId() {
        return this.id;
    }

    public void setId(Interger id) {
=======
    private Integer id;
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
>>>>>>> renameandconnectiondb
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}