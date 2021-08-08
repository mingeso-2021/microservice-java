package com.webapp.microservice.models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class EvaluatorTest{

    private Evaluator evaluator = new Evaluator(1, "evaluator1", "6.590.326-1", "ala@hotmail.com" , "+56973829574", 1);

    @Test
    public void testGetId() {
        Integer number = 1;
        assertEquals(number, evaluator.getId());
    }

    @Test
    public void testSetId() {
        Integer newId = 10;
        evaluator.setId(newId);
        assertEquals(newId, evaluator.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("evaluator1", evaluator.getName());
    }

    @Test
    public void testSetName() {
        String newName = "evaluatorTesting";
        evaluator.setName(newName);
        assertEquals("evaluatorTesting", evaluator.getName());
    }

    @Test
    public void testGetRut() {
        assertEquals("6.590.326-1", evaluator.getRut());
    }

    @Test
    public void testSetRut() {
        String newRut = "6.361.200-6";
        evaluator.setRut(newRut);
        assertEquals("6.361.200-6", evaluator.getRut());
    }

    @Test
    public void testGetEmail() {
        assertEquals("ala@hotmail.com", evaluator.getEmail());
    }

    @Test
    public void testSetEmail() {
        String newEmail = "ata@hotmail.com";
        evaluator.setEmail(newEmail);
        assertEquals("ata@hotmail.com", evaluator.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("+56973829574", evaluator.getPhone());
    }

    @Test
    public void testSetPhone() {
        String newPhone = "+56973824534";
        evaluator.setPhone(newPhone);
        assertEquals("+56973824534", evaluator.getPhone());
    }

    @Test
    public void testGetStatus() {
        assertEquals(1, evaluator.getStatus());
    }

    @Test
    public void testSetStatus() {
        int newStatus = 0;
        evaluator.setStatus(newStatus);
        assertEquals(0, evaluator.getStatus());
    }

}
