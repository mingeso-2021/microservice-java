package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulant;
import com.webapp.microservice.repositories.PostulantRepository;

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
public class PostulantService{

    private final PostulantRepository postulantRepository;
    PostulantService(PostulantRepository postulantRepository){
        this.postulantRepository = postulantRepository;
    }

    @GetMapping("/Postulants")
    public List<Postulant> getAllPostulant(){
        return postulantRepository.getAllPostulant();
    }

    @GetMapping("/Postulants/count")
    public String countPostulant(){
        int total = postulantRepository.countPostulant();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/Postulants/create")
    @ResponseBody
    public Postulant createPostulant(@RequestBody Postulant postulant){
        Postulant result = postulantRepository.createPostulant(postulant);
        return result;
    }

    @GetMapping("/Postulants/delete/{id}")
    public boolean deletePostulant(@PathVariable int id){
        return postulantRepository.deletePostulant(id);
    }
    @PostMapping("/Postulants/update")
    public boolean updatePostulant(@RequestBody Postulant postulant){
         return postulantRepository.updatePostulant(postulant);
    }

    @GetMapping("/Postulants/get/{id}")
    public Postulant getPostulant(@PathVariable int id){
        return postulantRepository.getPostulant(id);
    }
}