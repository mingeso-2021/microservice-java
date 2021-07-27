package com.webapp.microservice.services;

import com.webapp.microservice.models.Secretary;
import com.webapp.microservice.repositories.SecretaryRepository;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> renameandconnectiondb

import java.util.List;

@CrossOrigin
@RestController
<<<<<<< HEAD
=======
@RequestMapping(value = "secretaries")
>>>>>>> renameandconnectiondb
public class SecretaryService{

    private final SecretaryRepository secretaryRepository;
    SecretaryService(SecretaryRepository secretaryRepository){
        this.secretaryRepository = secretaryRepository;
    }

<<<<<<< HEAD
    @GetMapping("/Secretarys")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.getAllSecretary();
    }

<<<<<<< HEAD
    @GetMapping("/Secretarys/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
    public String countSecretary(){
        int total = secretaryRepository.countSecretary();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< HEAD
    @PostMapping("/Secretarys/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
    @ResponseBody
    public Secretary createSecretary(@RequestBody Secretary secretary){
        Secretary result = secretaryRepository.createSecretary(secretary);
        return result;
    }

<<<<<<< HEAD
    @GetMapping("/Secretarys/delete/{id}")
    public boolean deleteSecretary(@PathVariable int id){
        return secretaryRepository.deleteSecretary(id);
    }
    @PostMapping("/Secretarys/update")
=======
    @GetMapping("/delete/{id}")
    public boolean deleteSecretary(@PathVariable int id){
        return secretaryRepository.deleteSecretary(id);
    }
    @PostMapping("/update")
>>>>>>> renameandconnectiondb
    public boolean updateSecretary(@RequestBody Secretary secretary){
         return secretaryRepository.updateSecretary(secretary);
    }

<<<<<<< HEAD
    @GetMapping("/Secretarys/get/{id}")
=======
    @GetMapping("getbyid/{id}")
>>>>>>> renameandconnectiondb
    public Secretary getSecretary(@PathVariable int id){
        return secretaryRepository.getSecretary(id);
    }
}