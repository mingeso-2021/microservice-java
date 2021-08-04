package com.webapp.microservice.services;

import com.webapp.microservice.models.Postulant;
import com.webapp.microservice.repositories.PostulantRepository;

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
@RequestMapping(value = "postulants")
>>>>>>> renameandconnectiondb
=======
@RequestMapping(value = "postulants")
>>>>>>> Stashed changes
public class PostulantService{

    private final PostulantRepository postulantRepository;
    PostulantService(PostulantRepository postulantRepository){
        this.postulantRepository = postulantRepository;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulants")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getall")
>>>>>>> Stashed changes
    public List<Postulant> getAllPostulant(){
        return postulantRepository.getAllPostulant();
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulants/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/count")
>>>>>>> Stashed changes
    public String countPostulant(){
        int total = postulantRepository.countPostulant();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @PostMapping("/Postulants/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
=======
    @PostMapping("/create")
>>>>>>> Stashed changes
    @ResponseBody
    public Postulant createPostulant(@RequestBody Postulant postulant){
        Postulant result = postulantRepository.createPostulant(postulant);
        return result;
    }

<<<<<<< Updated upstream
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
=======
    @GetMapping("/delete/{id}")
    public boolean deletePostulant(@PathVariable int id){
        return postulantRepository.deletePostulant(id);
    }
    @PostMapping("/update")
>>>>>>> Stashed changes
    public boolean updatePostulant(@RequestBody Postulant postulant){
         return postulantRepository.updatePostulant(postulant);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Postulants/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> Stashed changes
    public Postulant getPostulant(@PathVariable int id){
        return postulantRepository.getPostulant(id);
    }
}