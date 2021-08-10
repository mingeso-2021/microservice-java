package com.webapp.microservice.servicesTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepositoryimp;
import com.webapp.microservice.services.DiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DiplomaServiceTest {

    private String url;
    private int port = 1818;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private DiplomaRepositoryimp diplomaRepositoryimp;

    @Mock
    private DiplomaService diplomaService;
    
    @BeforeEach
    void setUp(){
        url = String.format("http://143.110.148.226:%d/diplomas", port);
    }

    @Test
    void testCountDiploma() throws Exception{
        String extra = "Tienes en total 10 de la lista.";
        Mockito.when(diplomaService.countDiploma()).thenReturn(extra);
        RestTemplate restTemplate = new RestTemplate();
        String value = restTemplate.getForObject(url+"/count", String.class);
        System.out.println("value = " + value);
        assertEquals(value, diplomaService.countDiploma());
    }

    @Test
    void testCreateDiploma() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post(url+"/create")
                .content(asJsonString(new Diploma(9, "DiplomaTest3", 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
