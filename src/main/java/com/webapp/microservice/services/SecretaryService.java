package com.webapp.microservice.services;

import com.webapp.microservice.models.Secretary;
import com.webapp.microservice.repositories.SecretaryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "secretaries")
public class SecretaryService{

    private final SecretaryRepository secretaryRepository;
    SecretaryService(SecretaryRepository secretaryRepository){
        this.secretaryRepository = secretaryRepository;
    }

    @GetMapping("/getall")
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.getAllSecretary();
    }

    @GetMapping("/count")
    public String countSecretary(){
        int total = secretaryRepository.countSecretary();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/create")
    @ResponseBody
    public Secretary createSecretary(@RequestBody Secretary secretary){
        return secretaryRepository.createSecretary(secretary);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteSecretary(@PathVariable int id){
        return secretaryRepository.deleteSecretary(id);
    }

    @PostMapping("/update")
    public boolean updateSecretary(@RequestBody Secretary secretary){
         return secretaryRepository.updateSecretary(secretary);
    }

    @GetMapping("getbyid/{id}")
    public Secretary getSecretary(@PathVariable int id){
        return secretaryRepository.getSecretary(id);
    }
}