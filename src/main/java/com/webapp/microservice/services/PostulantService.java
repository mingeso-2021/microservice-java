package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulant;
import com.webapp.microservice.repositories.PostulantRepository;

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
@RequestMapping(value = "postulants")
>>>>>>> renameandconnectiondb
public class PostulantService{

    private final PostulantRepository postulantRepository;
    PostulantService(PostulantRepository postulantRepository){
        this.postulantRepository = postulantRepository;
    }

<<<<<<< HEAD
    @GetMapping("/Postulants")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
    public List<Postulant> getAllPostulant(){
        return postulantRepository.getAllPostulant();
    }

<<<<<<< HEAD
    @GetMapping("/Postulants/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
    public String countPostulant(){
        int total = postulantRepository.countPostulant();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< HEAD
    @PostMapping("/Postulants/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
    @ResponseBody
    public Postulant createPostulant(@RequestBody Postulant postulant){
        Postulant result = postulantRepository.createPostulant(postulant);
        return result;
    }

<<<<<<< HEAD
    @GetMapping("/Postulants/delete/{id}")
    public boolean deletePostulant(@PathVariable int id){
        return postulantRepository.deletePostulant(id);
    }
    @PostMapping("/Postulants/update")
=======
    @GetMapping("/delete/{id}")
    public boolean deletePostulant(@PathVariable int id){
        return postulantRepository.deletePostulant(id);
    }
    @PostMapping("/update")
>>>>>>> renameandconnectiondb
    public boolean updatePostulant(@RequestBody Postulant postulant){
         return postulantRepository.updatePostulant(postulant);
    }

<<<<<<< HEAD
    @GetMapping("/Postulants/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
    public Postulant getPostulant(@PathVariable int id){
        return postulantRepository.getPostulant(id);
    }
}