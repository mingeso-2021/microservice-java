package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulation;
import com.webapp.microservice.repositories.PostulationRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "postulations")
public class PostulationService{

    private final PostulationRepository postulationRepository;
    PostulationService(PostulationRepository postulationRepository){
        this.postulationRepository = postulationRepository;
    }

    @GetMapping("/getall")
    public List<Postulation> getAllPostulation(){
        return postulationRepository.getAllPostulation();
    }

    @GetMapping("/count")
    public String countPostulation(){
        int total = postulationRepository.countPostulation();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/create")
    @ResponseBody
    public Postulation createPostulation(@RequestBody Postulation postulation){
        Postulation result = postulationRepository.createPostulation(postulation);
        return result;
    }

    @GetMapping("/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }
    @PostMapping("/update")
    public boolean updatePostulation(@RequestBody Postulation postulation){
         return postulationRepository.updatePostulation(postulation);
    }

    @GetMapping("/getbyid/{id}")
    public Postulation getPostulation(@PathVariable int id){
        return postulationRepository.getPostulation(id);
    }
}