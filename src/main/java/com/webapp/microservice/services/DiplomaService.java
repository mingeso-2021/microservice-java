package com.webapp.microservice.services;

import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "diplomas")
public class DiplomaService{

    private final DiplomaRepository diplomaRepository;
    DiplomaService(DiplomaRepository diplomaRepository){
        this.diplomaRepository = diplomaRepository;
    }

    @GetMapping("/getall")
    public List<Diploma> getAllDiploma(){
        return diplomaRepository.getAllDiploma();
    }

    @GetMapping("/count")
    public String countDiploma(){
        int total = diplomaRepository.countDiploma();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/create")
    @ResponseBody
    public Diploma createDiploma(@RequestBody Diploma diploma){
        Diploma result = diplomaRepository.createDiploma(diploma);
        return result;
    }

    @GetMapping("/delete/{id}")
    public boolean deleteDiploma(@PathVariable int id){
        return diplomaRepository.deleteDiploma(id);
    }
    @PostMapping("/update")
    public boolean updateDiploma(@RequestBody Diploma diploma){
         return diplomaRepository.updateDiploma(diploma);
    }

    @GetMapping("/getbyid/{id}")
    public Diploma getDiploma(@PathVariable int id){
        return diplomaRepository.getDiploma(id);
    }
}
