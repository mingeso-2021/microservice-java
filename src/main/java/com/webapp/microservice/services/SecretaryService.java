package com.webapp.microservice.services;

import com.webapp.microservice.models.Secretary;
import com.webapp.microservice.repositories.SecretaryRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SecretaryService{

    private final SecretaryRepository secretaryRepository;
    SecretaryService(SecretaryRepository secretaryRepository){
        this.secretaryRepository = secretaryRepository;
    }

    @GetMapping("/Secretarys")
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.getAllSecretary();
    }

    @GetMapping("/Secretarys/count")
    public String countSecretary(){
        int total = secretaryRepository.countSecretary();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/Secretarys/create")
    @ResponseBody
    public Secretary createSecretary(@RequestBody Secretary secretary){
        Secretary result = secretaryRepository.createSecretary(secretary);
        return result;
    }

    @GetMapping("/Secretarys/delete/{id}")
    public boolean deleteSecretary(@PathVariable int id){
        return secretaryRepository.deleteSecretary(id);
    }
    @PostMapping("/Secretarys/update")
    public boolean updateSecretary(@RequestBody Secretary secretary){
         return secretaryRepository.updateSecretary(secretary);
    }

    @GetMapping("/Secretarys/get/{id}")
    public Secretary getSecretary(@PathVariable int id){
        return secretaryRepository.getSecretary(id);
    }
}