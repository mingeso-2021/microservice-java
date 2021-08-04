package com.webapp.microservice.services;

import com.webapp.microservice.models.Diploma;
import com.webapp.microservice.repositories.DiplomaRepository;

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
@RequestMapping(value = "diplomas")
>>>>>>> renameandconnectiondb
=======
@RequestMapping(value = "diplomas")
>>>>>>> Stashed changes
public class DiplomaService{

    private final DiplomaRepository diplomaRepository;
    DiplomaService(DiplomaRepository diplomaRepository){
        this.diplomaRepository = diplomaRepository;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Diplomas")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getall")
>>>>>>> Stashed changes
    public List<Diploma> getAllDiploma(){
        return diplomaRepository.getAllDiploma();
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Diplomas/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/count")
>>>>>>> Stashed changes
    public String countDiploma(){
        int total = diplomaRepository.countDiploma();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @PostMapping("/Diplomas/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
=======
    @PostMapping("/create")
>>>>>>> Stashed changes
    @ResponseBody
    public Diploma createDiploma(@RequestBody Diploma diploma){
        Diploma result = diplomaRepository.createDiploma(diploma);
        return result;
    }

<<<<<<< Updated upstream
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
=======
    @GetMapping("/delete/{id}")
    public boolean deleteDiploma(@PathVariable int id){
        return diplomaRepository.deleteDiploma(id);
    }
    @PostMapping("/update")
>>>>>>> Stashed changes
    public boolean updateDiploma(@RequestBody Diploma diploma){
         return diplomaRepository.updateDiploma(diploma);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Diplomas/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> Stashed changes
    public Diploma getDiploma(@PathVariable int id){
        return diplomaRepository.getDiploma(id);
    }
}
