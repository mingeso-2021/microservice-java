package com.webapp.microservice.repositories;
import java.util.List;
import com.webapp.microservice.models.Evaluator;

public interface EvaluatorRepository {
    public int countEvaluator();
    public List<Evaluator> getAllEvaluator();
    public Evaluator createEvaluator(Evaluator evaluator);
    public boolean deleteEvaluator(int id);
    public boolean updateEvaluator(Evaluator evaluator);
    public Evaluator getEvaluator(int id);
}
