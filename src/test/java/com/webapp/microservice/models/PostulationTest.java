package com.webapp.microservice.models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PostulationTest{

    private Postulation postulation = new Postulation(1, 1, 1, 1 , 1, 1);

    @Test
    public void testGetId() {
        Integer number = 1;
        assertEquals(number, postulation.getId());
    }

    @Test
    public void testSetId() {
        Integer newId = 2;
        postulation.setId(newId);
        assertEquals(newId, postulation.getId());
    }

    @Test
    public void testGetId_diploma() {
        Integer number = 1;
        assertEquals(number, postulation.getId_diploma());
    }

    @Test
    public void testSetId_diploma() {
        Integer newId = 3;
        postulation.setId_diploma(newId);
        assertEquals(newId, postulation.getId_diploma());
    }

    @Test
    public void testGetId_postulant() {
        Integer number = 1;
        assertEquals(number, postulation.getId_postulant());
    }

    @Test
    public void testSetId_postulant() {
        Integer newId = 4;
        postulation.setId_postulant(newId);
        assertEquals(newId, postulation.getId_postulant());
    }

    @Test
    public void testGetId_evaluator() {
        Integer number = 1;
        assertEquals(number, postulation.getId_evaluator());
    }

    @Test
    public void testSetId_evaluator() {
        Integer newId = 5;
        postulation.setId_evaluator(newId);
        assertEquals(newId, postulation.getId_evaluator());
    }

    @Test
    public void testGetId_secretary() {
        Integer number = 1;
        assertEquals(number, postulation.getId_secretary());
    }

    @Test
    public void testSetId_secretary() {
        Integer newId = 6;
        postulation.setId_secretary(newId);
        assertEquals(newId, postulation.getId_secretary());
    }

    @Test
    public void testGetStatus() {
        assertEquals(1, postulation.getStatus());
    }

    @Test
    public void testSetStatus() {
        int newStatus = 0;
        postulation.setStatus(newStatus);
        assertEquals(0, postulation.getStatus());
    }

}