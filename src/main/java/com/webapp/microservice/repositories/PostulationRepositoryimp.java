package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Postulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class PostulationRepositoryimp implements PostulationRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countPostulation() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM postulation").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Postulation> getAllPostulation() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from postulation")
                    .executeAndFetch(Postulation.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Postulation createPostulation(Postulation postulation) {
        try(Connection conn = sql2o.open()){
            int insertedId = countPostulation()+1;
            conn.createQuery("INSERT INTO postulation (id, id_diploma, id_postulant, id_evaluator, id_secretary)"+
            "values (:id, :postulationId_diploma, :postulationId_postulant, :postulationId_evaluator, :postulationId_secretary)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("postulationId_diploma", postulation.getId_diploma())
                    .addParameter("postulationId_postulant", postulation.getId_postulant())
                    .addParameter("postulationId_evaluator", postulation.getId_evaluator())
                    .addParameter("postulationId_secretary", postulation.getId_secretary())
                    .executeUpdate().getKey();
                    postulation.setId(insertedId);
            return postulation;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean deletePostulation(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM postulation WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean updatePostulation(Postulation postulation){
        String updateSql = "update postulation set id_diploma = :id_diploma, id_postulant = :id_postulant, id_evaluator = :id_evaluator, id_secretary = :id_secretary where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("id_diploma", postulation.getId_diploma())
                .addParameter("id_postulant", postulation.getId_postulant())
                .addParameter("id_evaluator", postulation.getId_evaluator())
                .addParameter("id_secretary", postulation.getId_secretary())
                .addParameter("id", postulation.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Postulation getPostulation(int id){
		String sql = "SELECT * FROM postulation where id=:id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Postulation.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

}