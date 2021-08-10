package com.webapp.microservice.modelsTest;
import com.webapp.microservice.models.Evaluator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EvaluatorTest{

    private Evaluator evaluator = new Evaluator(1, "evaluator1", "6.590.326-1", "ala@hotmail.com" , "+56973829574", 1);

    @Test
     void testGetId() {
        Integer number = 1;
        assertEquals(number, evaluator.getId());
    }

    @Test
    void testSetId() {
        Integer newId = 10;
        evaluator.setId(newId);
        assertEquals(newId, evaluator.getId());
    }

    @Test
    void testGetName() {
        assertEquals("evaluator1", evaluator.getName());
    }

    @Test
    void testSetName() {
        String newName = "evaluatorTesting";
        evaluator.setName(newName);
        assertEquals("evaluatorTesting", evaluator.getName());
    }

    @Test
    void testGetRut() {
        assertEquals("6.590.326-1", evaluator.getRut());
    }

    @Test
    void testSetRut() {
        String newRut = "6.361.200-6";
        evaluator.setRut(newRut);
        assertEquals("6.361.200-6", evaluator.getRut());
    }

    @Test
    void testGetEmail() {
        assertEquals("ala@hotmail.com", evaluator.getEmail());
    }

    @Test
    void testSetEmail() {
        String newEmail = "ata@hotmail.com";
        evaluator.setEmail(newEmail);
        assertEquals("ata@hotmail.com", evaluator.getEmail());
    }

    @Test
    void testGetPhone() {
        assertEquals("+56973829574", evaluator.getPhone());
    }

    @Test
    void testSetPhone() {
        String newPhone = "+56973824534";
        evaluator.setPhone(newPhone);
        assertEquals("+56973824534", evaluator.getPhone());
    }

    @Test
    void testGetStatus() {
        assertEquals(1, evaluator.getStatus());
    }

    @Test
    void testSetStatus() {
        int newStatus = 0;
        evaluator.setStatus(newStatus);
        assertEquals(0, evaluator.getStatus());
    }

}
