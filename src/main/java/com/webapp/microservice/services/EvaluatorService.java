package com.webapp.microservice.services;
import com.webapp.microservice.models.Evaluator;
import com.webapp.microservice.repositories.EvaluatorRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "evaluators")
public class EvaluatorService{

    private final EvaluatorRepository evaluatorRepository;
    EvaluatorService(EvaluatorRepository evaluatorRepository){
        this.evaluatorRepository = evaluatorRepository;
    }

    @GetMapping("/getall")
    public List<Evaluator> getAllEvaluator(){
        return evaluatorRepository.getAllEvaluator();
    }

    @GetMapping("/count")
    public String countEvaluator(){
        int total = evaluatorRepository.countEvaluator();
        return String.format("Tienes en total, %s de la lista.", total);
    }

    @PostMapping("/create")
    @ResponseBody
    public Evaluator createEvaluator(@RequestBody Evaluator evaluator){
        Evaluator result = evaluatorRepository.createEvaluator(evaluator);
        return result;
    }

    @GetMapping("/delete/{id}")
    public boolean deleteEvaluator(@PathVariable int id){
        return evaluatorRepository.deleteEvaluator(id);
    }

    @PostMapping("/update")
    public boolean updateEvaluator(@RequestBody Evaluator evaluator){
         return evaluatorRepository.updateEvaluator(evaluator);
    }

    @GetMapping("/getbyid/{id}")
    public Evaluator getEvaluator(@PathVariable int id){
        return evaluatorRepository.getEvaluator(id);
    }
}