package com.webapp.microservice.services;

import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepository;

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
public class DiplomaService{

    private final DiplomaRepository diplomaRepository;
    DiplomaService(DiplomaRepository diplomaRepository){
        this.diplomaRepository = diplomaRepository;
    }

    @GetMapping("/Diplomas")
    public List<Diploma> getAllDiploma(){
        return diplomaRepository.getAllDiploma();
    }

    @GetMapping("/Diplomas/count")
    public String countDiploma(){
        int total = diplomaRepository.countDiploma();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/Diplomas/create")
    @ResponseBody
    public Diploma createDiploma(@RequestBody Diploma diploma){
        Diploma result = diplomaRepository.createDiploma(diploma);
        return result;
    }

    @GetMapping("/Diplomas/delete/{id}")
    public boolean deleteDiploma(@PathVariable int id){
        return diplomaRepository.deleteDiploma(id);
    }
    @PostMapping("/Diplomas/update")
    public boolean updateDiploma(@RequestBody Diploma diploma){
         return diplomaRepository.updateDiploma(diploma);
    }

    @GetMapping("/Diplomas/get/{id}")
    public Diploma getDiploma(@PathVariable int id){
        return diplomaRepository.getDiploma(id);
    }
}
