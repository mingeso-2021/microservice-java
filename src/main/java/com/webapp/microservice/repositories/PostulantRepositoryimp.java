package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Postulant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class PostulantRepositoryimp implements PostulantRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countPostulant() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM postulant").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Postulant> getAllPostulant() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from postulant")
                    .executeAndFetch(Postulant.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Postulant createPostulant(Postulant postulant) {
        try(Connection conn = sql2o.open()){
            int insertedId = countPostulant()+1;
            conn.createQuery("INSERT INTO postulant (id, name, rut, email, phone, status)"+
            "values (:id, :postulantName, :postulantRut, :postulantEmail, :postulantPhone, :postulantStatus)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("postulantName", postulant.getName())
                    .addParameter("postulantRut", postulant.getRut())
                    .addParameter("postulantEmail", postulant.getEmail())
                    .addParameter("postulantPhone", postulant.getPhone())
                    .addParameter("postulantStatus", postulant.getStatus())
                    .executeUpdate().getKey();
                    postulant.setId(insertedId);
            return postulant;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean deletePostulant(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM postulant WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean updatePostulant(Postulant postulant){
        String updateSql = "update postulant set name = :name, rut = :rut, email = :email, phone = :phone, status = :status where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("name", postulant.getName())
                .addParameter("rut", postulant.getRut())
                .addParameter("email", postulant.getEmail())
                .addParameter("phone", postulant.getPhone())
                .addParameter("phone", postulant.getStatus())
                .addParameter("id", postulant.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Postulant getPostulant(int id){
		String sql = "SELECT * FROM postulant where id=:id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Postulant.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

}