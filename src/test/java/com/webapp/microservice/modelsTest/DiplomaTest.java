package com.webapp.microservice.modelsTest;

import com.webapp.microservice.models.Diploma;
import org.junit.jupiter.api.Test;


import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DiplomaTest{

    private Diploma diploma = new Diploma(1, "diploma1", 1);

    @Test
    void testGetId() {
        Integer number = 1;
        assertEquals(number, diploma.getId());
    }

    @Test
    void testSetId() {
        Integer newId = 7;
        diploma.setId(newId);
        assertEquals(newId, diploma.getId());
    }

    @Test
    void testGetName() {
        assertEquals("diploma1", diploma.getName());
    }

    @Test
    void testSetName() {
        String newName = "diplomaTesting";
        diploma.setName(newName);
        assertEquals("diplomaTesting", diploma.getName());
    }

    @Test
    void testGetStatus() {
        assertEquals(1, diploma.getStatus());
    }

    @Test
    void testSetStatus() {
        int newStatus = 0;
        diploma.setStatus(newStatus);
        assertEquals(0, diploma.getStatus());
    }

}
