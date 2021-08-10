package com.webapp.microservice.models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PostulantTest{

    private Postulant postulant = new Postulant(1, "postulant1", "10.310.326-1", "postu@hotmail.com" , "+56967829574", 1);

    @Test
    void testGetId() {
        Integer number = 1;
        assertEquals(number, postulant.getId());
    }

    @Test
    void testSetId() {
        Integer newId = 10;
        postulant.setId(newId);
        assertEquals(newId, postulant.getId());
    }

    @Test
    void testGetName() {
        assertEquals("postulant1", postulant.getName());
    }

    @Test
    void testSetName() {
        String newName = "postulantTesting";
        postulant.setName(newName);
        assertEquals("postulantTesting", postulant.getName());
    }

    @Test
    void testGetRut() {
        assertEquals("10.310.326-1", postulant.getRut());
    }

    @Test
    void testSetRut() {
        String newRut = "6.361.200-6";
        postulant.setRut(newRut);
        assertEquals("6.361.200-6", postulant.getRut());
    }

    @Test
    void testGetEmail() {
        assertEquals("postu@hotmail.com", postulant.getEmail());
    }

    @Test
    void testSetEmail() {
        String newEmail = "postulant@hotmail.com";
        postulant.setEmail(newEmail);
        assertEquals("postulant@hotmail.com", postulant.getEmail());
    }

    @Test
    void testGetPhone() {
        assertEquals("+56967829574", postulant.getPhone());
    }

    @Test
    void testSetPhone() {
        String newPhone = "+56973824534";
        postulant.setPhone(newPhone);
        assertEquals("+56973824534", postulant.getPhone());
    }

    @Test
    void testGetStatus() {
        assertEquals(1, postulant.getStatus());
    }

    @Test
    void testSetStatus() {
        int newStatus = 0;
        postulant.setStatus(newStatus);
        assertEquals(0, postulant.getStatus());
    }

}