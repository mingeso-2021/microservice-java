package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulation;
import com.webapp.microservice.repositories.PostulationRepository;

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
@RequestMapping(value = "postulations")
>>>>>>> renameandconnectiondb
=======
@RequestMapping(value = "postulations")
>>>>>>> Stashed changes
public class PostulationService{

    private final PostulationRepository postulationRepository;
    PostulationService(PostulationRepository postulationRepository){
        this.postulationRepository = postulationRepository;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulations")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getall")
>>>>>>> Stashed changes
    public List<Postulation> getAllPostulation(){
        return postulationRepository.getAllPostulation();
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulations/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/count")
>>>>>>> Stashed changes
    public String countPostulation(){
        int total = postulationRepository.countPostulation();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @PostMapping("/Postulations/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
=======
    @PostMapping("/create")
>>>>>>> Stashed changes
    @ResponseBody
    public Postulation createPostulation(@RequestBody Postulation postulation){
        Postulation result = postulationRepository.createPostulation(postulation);
        return result;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulations/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }
    @PostMapping("/Postulations/update")
=======
    @GetMapping("/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }
    @PostMapping("/update")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }
    @PostMapping("/update")
>>>>>>> Stashed changes
    public boolean updatePostulation(@RequestBody Postulation postulation){
         return postulationRepository.updatePostulation(postulation);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulations/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> Stashed changes
    public Postulation getPostulation(@PathVariable int id){
        return postulationRepository.getPostulation(id);
    }
}