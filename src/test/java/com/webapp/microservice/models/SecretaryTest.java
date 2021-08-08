package com.webapp.microservice.models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class SecretaryTest{

    private Secretary secretary = new Secretary(1, "secretary1", "10.310.326-1", "secre@hotmail.com" , "+56967829574", 1);

    @Test
    public void testGetId() {
        Integer number = 1;
        assertEquals(number, secretary.getId());
    }

    @Test
    public void testSetId() {
        Integer newId = 10;
        secretary.setId(newId);
        assertEquals(newId, secretary.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("secretary1", secretary.getName());
    }

    @Test
    public void testSetName() {
        String newName = "secretaryTesting";
        secretary.setName(newName);
        assertEquals("secretaryTesting", secretary.getName());
    }

    @Test
    public void testGetRut() {
        assertEquals("10.310.326-1", secretary.getRut());
    }

    @Test
    public void testSetRut() {
        String newRut = "6.361.200-6";
        secretary.setRut(newRut);
        assertEquals("6.361.200-6", secretary.getRut());
    }

    @Test
    public void testGetEmail() {
        assertEquals("secre@hotmail.com", secretary.getEmail());
    }

    @Test
    public void testSetEmail() {
        String newEmail = "secreda@hotmail.com";
        secretary.setEmail(newEmail);
        assertEquals("secreda@hotmail.com", secretary.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("+56967829574", secretary.getPhone());
    }

    @Test
    public void testSetPhone() {
        String newPhone = "+56973824534";
        secretary.setPhone(newPhone);
        assertEquals("+56973824534", secretary.getPhone());
    }

    @Test
    public void testGetStatus() {
        assertEquals(1, secretary.getStatus());
    }

    @Test
    public void testSetStatus() {
        int newStatus = 0;
        secretary.setStatus(newStatus);
        assertEquals(0, secretary.getStatus());
    }

}