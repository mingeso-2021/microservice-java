package com.webapp.microservice.models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PostulantTest{

    private Postulant postulant = new Postulant(1, "postulant1", "10.310.326-1", "postu@hotmail.com" , "+56967829574", 1);

    @Test
    public void testGetId() {
        Integer number = 1;
        assertEquals(number, postulant.getId());
    }

    @Test
    public void testSetId() {
        Integer newId = 10;
        postulant.setId(newId);
        assertEquals(newId, postulant.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("postulant1", postulant.getName());
    }

    @Test
    public void testSetName() {
        String newName = "postulantTesting";
        postulant.setName(newName);
        assertEquals("postulantTesting", postulant.getName());
    }

    @Test
    public void testGetRut() {
        assertEquals("10.310.326-1", postulant.getRut());
    }

    @Test
    public void testSetRut() {
        String newRut = "6.361.200-6";
        postulant.setRut(newRut);
        assertEquals("6.361.200-6", postulant.getRut());
    }

    @Test
    public void testGetEmail() {
        assertEquals("postu@hotmail.com", postulant.getEmail());
    }

    @Test
    public void testSetEmail() {
        String newEmail = "postulant@hotmail.com";
        postulant.setEmail(newEmail);
        assertEquals("postulant@hotmail.com", postulant.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("+56967829574", postulant.getPhone());
    }

    @Test
    public void testSetPhone() {
        String newPhone = "+56973824534";
        postulant.setPhone(newPhone);
        assertEquals("+56973824534", postulant.getPhone());
    }

    @Test
    public void testGetStatus() {
        assertEquals(1, postulant.getStatus());
    }

    @Test
    public void testSetStatus() {
        int newStatus = 0;
        postulant.setStatus(newStatus);
        assertEquals(0, postulant.getStatus());
    }

}