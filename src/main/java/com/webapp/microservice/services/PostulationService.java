package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulation;
import com.webapp.microservice.repositories.PostulationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
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
        return postulationRepository.createPostulation(postulation);
    }

    @GetMapping("/delete/{id}")
    public boolean deletePostulation(@PathVariable int id){
        return postulationRepository.deletePostulation(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public void updatePostulation(@PathVariable(value = "id") int id, @RequestBody Postulation postulation){
        System.out.println("Esta llegando: " + postulation.getStatus());
        postulationRepository.updatePostulation( id, postulation );
    }

    @GetMapping("/getbyid/{id}")
    public Postulation getPostulation(@PathVariable int id){
        return postulationRepository.getPostulation(id);
    }
}