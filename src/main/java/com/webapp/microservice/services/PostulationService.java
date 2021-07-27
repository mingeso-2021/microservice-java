package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulation;
import com.webapp.microservice.repositories.PostulationRepository;

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
@RequestMapping(value = "postulations")
>>>>>>> renameandconnectiondb
public class PostulationService{

    private final PostulationRepository postulationRepository;
    PostulationService(PostulationRepository postulationRepository){
        this.postulationRepository = postulationRepository;
    }

<<<<<<< HEAD
    @GetMapping("/Postulations")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
    public List<Postulation> getAllPostulation(){
        return postulationRepository.getAllPostulation();
    }

<<<<<<< HEAD
    @GetMapping("/Postulations/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
    public String countPostulation(){
        int total = postulationRepository.countPostulation();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< HEAD
    @PostMapping("/Postulations/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
    @ResponseBody
    public Postulation createPostulation(@RequestBody Postulation postulation){
        Postulation result = postulationRepository.createPostulation(postulation);
        return result;
    }

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
    public boolean updatePostulation(@RequestBody Postulation postulation){
         return postulationRepository.updatePostulation(postulation);
    }

<<<<<<< HEAD
    @GetMapping("/Postulations/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
    public Postulation getPostulation(@PathVariable int id){
        return postulationRepository.getPostulation(id);
    }
}