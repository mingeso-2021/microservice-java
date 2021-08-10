package com.webapp.microservice.services;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DiplomaServiceTest {

    private String url;
    private int port = 1818;

    @InjectMocks
    private DiplomaRepositoryimp diplomaRepositoryimp;

    @Mock
    private DiplomaService diplomaService;

    @BeforeEach
    void setUp(){
        //Gson gson = new Gson();
        url = String.format("http://143.110.148.226:%d/diplomas", port);
        String extra = "Tienes en total 5 de la lista.";
        /*String json = "[{'id'='26', 'name'='Diplomado en Ciencia de Datos Aplicada', 'status'='1'}," +
                " {'id'='27', 'name'='Diplomado en Ciberseguridad (Gestión, Técnico y Legal)', 'status'='1'}," +
                " {'id'='28', 'name'='Diplomado en Riesgo Operacional y Continuidad del Negocio en Procesos y TICs', 'status'='1'}," +
                " {'id'='29', 'name'='Diplomado en Control, Seguridad y Auditoría Computacional', 'status'='1'}," +
                " {'id'='30', 'name'='Diplomado en Peritaje Informático', 'status'='1'}]";
        List<Diploma> diplomas = new ArrayList<>();
         */
        //diplomas = gson.fromJson(json, diplomas.getClass());
        Mockito.when(diplomaService.countDiploma()).thenReturn(extra);
        //Mockito.when(diplomaService.getAllDiploma()).thenReturn(diplomas);

    }

    @Test
    void testCountDiploma() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String value = restTemplate.getForObject(url+"/count", String.class);
        System.out.println("value = " + value);
        assertEquals(value, diplomaService.countDiploma());
    }
    /*
    @Test
    void testGetAllDiploma() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        List<Diploma> diplomas = new ArrayList<>();
        diplomas = restTemplate.getForObject(url+"/getall", diplomas.getClass());
        System.out.println(diplomas);
        System.out.println(diplomaService.getAllDiploma());
        //assertEquals(diplomas, diplomaService.getAllDiploma());
        assertTrue(diplomaService.getAllDiploma().equals(diplomas));

    }
    
     */

}
