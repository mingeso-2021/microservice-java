package com.webapp.microservice.services;

import com.webapp.microservice.models.Evaluator;
import com.webapp.microservice.repositories.EvaluatorRepository;

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
public class EvaluatorService{

    private final EvaluatorRepository evaluatorRepository;
    EvaluatorService(EvaluatorRepository evaluatorRepository){
        this.evaluatorRepository = evaluatorRepository;
    }

    @GetMapping("/Evaluators")
    public List<Evaluator> getAllEvaluator(){
        return evaluatorRepository.getAllEvaluator();
    }

    @GetMapping("/Evaluators/count")
    public String countEvaluator(){
        int total = evaluatorRepository.countEvaluator();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/Evaluators/create")
    @ResponseBody
    public Evaluator createEvaluator(@RequestBody Evaluator evaluator){
        Evaluator result = evaluatorRepository.createEvaluator(evaluator);
        return result;
    }

    @GetMapping("/Evaluators/delete/{id}")
    public boolean deleteEvaluator(@PathVariable int id){
        return evaluatorRepository.deleteEvaluator(id);
    }
    @PostMapping("/Evaluators/update")
    public boolean updateEvaluator(@RequestBody Evaluator evaluator){
         return evaluatorRepository.updateEvaluator(evaluator);
    }

    @GetMapping("/Evaluators/get/{id}")
    public Evaluator getEvaluator(@PathVariable int id){
        return evaluatorRepository.getEvaluator(id);
    }
}