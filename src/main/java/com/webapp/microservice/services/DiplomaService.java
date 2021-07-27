package com.webapp.microservice.services;

import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepository;

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
@RequestMapping(value = "diplomas")
>>>>>>> renameandconnectiondb
public class DiplomaService{

    private final DiplomaRepository diplomaRepository;
    DiplomaService(DiplomaRepository diplomaRepository){
        this.diplomaRepository = diplomaRepository;
    }

<<<<<<< HEAD
    @GetMapping("/Diplomas")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
    public List<Diploma> getAllDiploma(){
        return diplomaRepository.getAllDiploma();
    }

<<<<<<< HEAD
    @GetMapping("/Diplomas/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
    public String countDiploma(){
        int total = diplomaRepository.countDiploma();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< HEAD
    @PostMapping("/Diplomas/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
    @ResponseBody
    public Diploma createDiploma(@RequestBody Diploma diploma){
        Diploma result = diplomaRepository.createDiploma(diploma);
        return result;
    }

<<<<<<< HEAD
    @GetMapping("/Diplomas/delete/{id}")
    public boolean deleteDiploma(@PathVariable int id){
        return diplomaRepository.deleteDiploma(id);
    }
    @PostMapping("/Diplomas/update")
=======
    @GetMapping("/delete/{id}")
    public boolean deleteDiploma(@PathVariable int id){
        return diplomaRepository.deleteDiploma(id);
    }
    @PostMapping("/update")
>>>>>>> renameandconnectiondb
    public boolean updateDiploma(@RequestBody Diploma diploma){
         return diplomaRepository.updateDiploma(diploma);
    }

<<<<<<< HEAD
    @GetMapping("/Diplomas/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
    public Diploma getDiploma(@PathVariable int id){
        return diplomaRepository.getDiploma(id);
    }
}
