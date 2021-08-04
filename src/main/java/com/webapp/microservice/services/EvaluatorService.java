package com.webapp.microservice.services;

import com.webapp.microservice.models.Evaluator;
import com.webapp.microservice.repositories.EvaluatorRepository;

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
@RequestMapping(value = "evaluators")
>>>>>>> renameandconnectiondb
=======
@RequestMapping(value = "evaluators")
>>>>>>> Stashed changes
public class EvaluatorService{

    private final EvaluatorRepository evaluatorRepository;
    EvaluatorService(EvaluatorRepository evaluatorRepository){
        this.evaluatorRepository = evaluatorRepository;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Evaluators")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getall")
>>>>>>> Stashed changes
    public List<Evaluator> getAllEvaluator(){
        return evaluatorRepository.getAllEvaluator();
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Evaluators/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/count")
>>>>>>> Stashed changes
    public String countEvaluator(){
        int total = evaluatorRepository.countEvaluator();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @PostMapping("/Evaluators/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
=======
    @PostMapping("/create")
>>>>>>> Stashed changes
    @ResponseBody
    public Evaluator createEvaluator(@RequestBody Evaluator evaluator){
        Evaluator result = evaluatorRepository.createEvaluator(evaluator);
        return result;
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Evaluators/delete/{id}")
    public boolean deleteEvaluator(@PathVariable int id){
        return evaluatorRepository.deleteEvaluator(id);
    }
    @PostMapping("/Evaluators/update")
=======
    @GetMapping("/delete/{id}")
    public boolean deleteEvaluator(@PathVariable int id){
        return evaluatorRepository.deleteEvaluator(id);
    }
    @PostMapping("/update")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/delete/{id}")
    public boolean deleteEvaluator(@PathVariable int id){
        return evaluatorRepository.deleteEvaluator(id);
    }
    @PostMapping("/update")
>>>>>>> Stashed changes
    public boolean updateEvaluator(@RequestBody Evaluator evaluator){
         return evaluatorRepository.updateEvaluator(evaluator);
    }

<<<<<<< Updated upstream
<<<<<<< HEAD
    @GetMapping("/Evaluators/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> Stashed changes
    public Evaluator getEvaluator(@PathVariable int id){
        return evaluatorRepository.getEvaluator(id);
    }
}