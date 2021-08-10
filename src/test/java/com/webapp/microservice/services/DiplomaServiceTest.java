package com.webapp.microservice.services;


import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepositoryimp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DiplomaServiceTest {

    private String url;
    private int port = 1818;

    @InjectMocks
    private DiplomaRepositoryimp diplomaRepositoryimp;

    @Mock
    private DiplomaService diplomaService;

    @Mock
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp(){
        url = String.format("http://localhost:%d/diplomas", port);
        String extra = "Tienes en total 5 de la lista.";
        Mockito.when(diplomaService.countDiploma()).thenReturn(extra);
    }

    @Test
    public void testCountDiploma(){
        RestTemplate restTemplate = new RestTemplate();
        String value = restTemplate.getForObject(url+"/count", String.class);
        assertEquals(value, diplomaService.countDiploma());
    }

}
