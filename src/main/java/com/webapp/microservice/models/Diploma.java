package com.webapp.microservice.models;

public class Diploma {
<<<<<<< Updated upstream
    
    private Interger id;
=======
    private Integer id;
>>>>>>> Stashed changes
    private String name;

    public Integer getId() {
        return this.id;
    }

<<<<<<< Updated upstream
    public void setId(Interger id) {
=======
    private Integer id;
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
>>>>>>> renameandconnectiondb
=======
    public void setId(Integer id) {
>>>>>>> Stashed changes
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}