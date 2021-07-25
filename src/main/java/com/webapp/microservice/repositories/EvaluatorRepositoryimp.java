package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EvaluatorRepositoryimp implements EvaluatorRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEvaluator() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM evaluator").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Evaluator> getAllEvaluator() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from evaluator")
                    .executeAndFetch(Evaluator.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Evaluator createEvaluator(Evaluator evaluator) {
        try(Connection conn = sql2o.open()){
            int insertedId = countEvaluator()+1;
            conn.createQuery("INSERT INTO evaluator (id, name, rut, email, phone)"+
            "values (:id, :evaluatorName, :evaluatorRut, :evaluatorEmail, :evaluatorPhone)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("evaluatorName", evaluator.getName())
                    .addParameter("evaluatorRut", evaluator.getRut())
                    .addParameter("evaluatorEmail", evaluator.getEmail())
                    .addParameter("evaluatorPhone", evaluator.getPhone())
                    .executeUpdate().getKey();
                    evaluator.setId(insertedId);
            return evaluator;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean deleteEvaluator(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM evaluator WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean updateEvaluator(Evaluator evaluator){
        String updateSql = "update evaluator set name = :name, rut = :rut, email = :email, phone = :phone where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("name", evaluator.getName())
                .addParameter("rut", evaluator.getRut())
                .addParameter("email", evaluator.getEmail())
                .addParameter("phone", evaluator.getPhone())
                .addParameter("id", evaluator.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Evaluator getEvaluator(int id){
		String sql = "SELECT * FROM evaluator where id=:id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Evaluator.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

}