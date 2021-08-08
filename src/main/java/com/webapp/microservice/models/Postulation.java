package com.webapp.microservice.models;

public class Postulation {

    private Integer id;
    private Integer id_diploma;
    private Integer id_postulant;
    private Integer id_evaluator;
    private Integer id_secretary;
    private Integer status;

    public Postulation(Integer id, Integer id_diploma, Integer id_postulant, Integer id_evaluator,Integer id_secretary,Integer status) {
        this.id = id;
        this.id_diploma = id_diploma;
        this.id_postulant = id_postulant;
        this.id_evaluator = id_evaluator;
        this.id_secretary = id_secretary;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_diploma() {
        return id_diploma;
    }

    public void setId_diploma(Integer id_diploma) {
        this.id_diploma = id_diploma;
    }

    public Integer getId_postulant() {
        return id_postulant;
    }

    public void setId_postulant(Integer id_postulant) {
        this.id_postulant = id_postulant;
    }

    public Integer getId_evaluator() {
        return id_evaluator;
    }

    public void setId_evaluator(Integer id_evaluator) {
        this.id_evaluator = id_evaluator;
    }

    public Integer getId_secretary() {
        return id_secretary;
    }

    public void setId_secretary(Integer id_secretary) {
        this.id_secretary = id_secretary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}