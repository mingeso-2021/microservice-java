package com.webapp.microservice.services;

import com.webapp.microservice.models.Secretary;
import com.webapp.microservice.repositories.SecretaryRepository;

<<<<<<< Updated upstream
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
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> Stashed changes

import java.util.List;

@CrossOrigin
@RestController
<<<<<<< Updated upstream
<<<<<<< HEAD
=======
@RequestMapping(value = "secretaries")
>>>>>>> renameandconnectiondb
=======
@RequestMapping(value = "secretaries")
>>>>>>> Stashed changes
public class SecretaryService{

    private final SecretaryRepository secretaryRepository;
    SecretaryService(SecretaryRepository secretaryRepository){
        this.secretaryRepository = secretaryRepository;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Secretarys")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getall")
>>>>>>> Stashed changes
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.getAllSecretary();
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Secretarys/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/count")
>>>>>>> Stashed changes
    public String countSecretary(){
        int total = secretaryRepository.countSecretary();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @PostMapping("/Secretarys/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
=======
    @PostMapping("/create")
>>>>>>> Stashed changes
    @ResponseBody
    public Secretary createSecretary(@RequestBody Secretary secretary){
        Secretary result = secretaryRepository.createSecretary(secretary);
        return result;
    }

<<<<<<< Updated upstream
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
=======
    @GetMapping("/delete/{id}")
    public boolean deleteSecretary(@PathVariable int id){
        return secretaryRepository.deleteSecretary(id);
    }
    @PostMapping("/update")
>>>>>>> Stashed changes
    public boolean updateSecretary(@RequestBody Secretary secretary){
         return secretaryRepository.updateSecretary(secretary);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Secretarys/get/{id}")
=======
    @GetMapping("getbyid/{id}")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("getbyid/{id}")
>>>>>>> Stashed changes
    public Secretary getSecretary(@PathVariable int id){
        return secretaryRepository.getSecretary(id);
    }
}