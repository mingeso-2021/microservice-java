package com.webapp.microservice.services;

import com.webapp.microservice.models.Evaluator;
import com.webapp.microservice.repositories.EvaluatorRepository;

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
@RequestMapping(value = "evaluators")
>>>>>>> renameandconnectiondb
public class EvaluatorService{

    private final EvaluatorRepository evaluatorRepository;
    EvaluatorService(EvaluatorRepository evaluatorRepository){
        this.evaluatorRepository = evaluatorRepository;
    }

<<<<<<< HEAD
    @GetMapping("/Evaluators")
=======
    @GetMapping("/getall")
>>>>>>> renameandconnectiondb
    public List<Evaluator> getAllEvaluator(){
        return evaluatorRepository.getAllEvaluator();
    }

<<<<<<< HEAD
    @GetMapping("/Evaluators/count")
=======
    @GetMapping("/count")
>>>>>>> renameandconnectiondb
    public String countEvaluator(){
        int total = evaluatorRepository.countEvaluator();
        return String.format("Tienes en total, %s de la lista.", total);
    }

<<<<<<< HEAD
    @PostMapping("/Evaluators/create")
=======
    @PostMapping("/create")
>>>>>>> renameandconnectiondb
    @ResponseBody
    public Evaluator createEvaluator(@RequestBody Evaluator evaluator){
        Evaluator result = evaluatorRepository.createEvaluator(evaluator);
        return result;
    }

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
    public boolean updateEvaluator(@RequestBody Evaluator evaluator){
         return evaluatorRepository.updateEvaluator(evaluator);
    }

<<<<<<< HEAD
    @GetMapping("/Evaluators/get/{id}")
=======
    @GetMapping("/getbyid/{id}")
>>>>>>> renameandconnectiondb
    public Evaluator getEvaluator(@PathVariable int id){
        return evaluatorRepository.getEvaluator(id);
    }
}