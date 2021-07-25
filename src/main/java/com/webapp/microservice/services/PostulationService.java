package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulation;
import com.webapp.microservice.repositories.PostulationRepository;

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
public class PostulationService{

    private final PostulationRepository postulationRepository;
    PostulationService(PostulationRepository postulationRepository){
        this.postulationRepository = postulationRepository;
    }

    @GetMapping("/Postulations")
    public List<Postulation> getAllPostulation(){
        return postulationRepository.getAllPostulation();
    }

    @GetMapping("/Postulations/count")
    public String countPostulation(){
        int total = postulationRepository.countPostulation();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/Postulations/create")
    @ResponseBody
    public Postulation createPostulation(@RequestBody Postulation postulation){
        Postulation result = postulationRepository.createPostulation(postulation);
        return result;
    }

    @GetMapping("/Postulations/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }
    @PostMapping("/Postulations/update")
    public boolean updatePostulation(@RequestBody Postulation postulation){
         return postulationRepository.updatePostulation(postulation);
    }

    @GetMapping("/Postulations/get/{id}")
    public Postulation getPostulation(@PathVariable int id){
        return postulationRepository.getPostulation(id);
    }
}