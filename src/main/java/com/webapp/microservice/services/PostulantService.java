package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulant;
import com.webapp.microservice.repositories.PostulantRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "postulants")
public class PostulantService{

    private final PostulantRepository postulantRepository;
    PostulantService(PostulantRepository postulantRepository){
        this.postulantRepository = postulantRepository;
    }

    @GetMapping("/getall")
    public List<Postulant> getAllPostulant(){
        return postulantRepository.getAllPostulant();
    }

    @GetMapping("/count")
    public String countPostulant(){
        int total = postulantRepository.countPostulant();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/create")
    @ResponseBody
    public Postulant createPostulant(@RequestBody Postulant postulant){
        return  postulantRepository.createPostulant(postulant);
    }

    @GetMapping("/delete/{id}")
    public boolean deletePostulant(@PathVariable int id){
        return postulantRepository.deletePostulant(id);
    }

    @PostMapping("/update")
    public boolean updatePostulant(@RequestBody Postulant postulant){
         return postulantRepository.updatePostulant(postulant);
    }

    @GetMapping("/getbyid/{id}")
    public Postulant getPostulant(@PathVariable int id){
        return postulantRepository.getPostulant(id);
    }
}