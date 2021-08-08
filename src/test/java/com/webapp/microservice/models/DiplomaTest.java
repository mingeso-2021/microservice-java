package com.webapp.microservice.models;

import org.junit.jupiter.api.Test;


import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DiplomaTest{

    private Diploma diploma = new Diploma(1, "diploma1", 1);

    @Test
    public void testGetId() {
        Integer number = 1;
        assertEquals(number, diploma.getId());
    }

    @Test
    public void testSetId() {
        Integer newId = 7;
        diploma.setId(newId);
        assertEquals(newId, diploma.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("diploma1", diploma.getName());
    }

    @Test
    public void testSetName() {
        String newName = "diplomaTesting";
        diploma.setName(newName);
        assertEquals("diplomaTesting", diploma.getName());
    }

    @Test
    public void testGetStatus() {
        assertEquals(1, diploma.getStatus());
    }

    @Test
    public void testSetStatus() {
        int newStatus = 0;
        diploma.setStatus(newStatus);
        assertEquals(0, diploma.getStatus());
    }

}
