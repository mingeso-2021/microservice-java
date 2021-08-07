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
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) FROM postulant").executeScalar(Integer.class);
            return total;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }

    }

    @Override
    public List<Postulant> getAllPostulant() {
        Connection conn = sql2o.open();
        List<Postulant> applicants;
        try(conn){
            applicants=conn.createQuery("select * from postulant")
                    .executeAndFetch(Postulant.class);
            return applicants;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public Postulant createPostulant(Postulant postulant) {
        Connection conn = sql2o.open();
        try(conn){
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
        finally {
            conn.close();
        }
        
    }
    @Override
    public boolean deletePostulant(int id){
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery("DELETE FROM postulant WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            conn.close();
        }

    }
    @Override
    public boolean updatePostulant(Postulant postulant){
        String updateSql = "update postulant set name = :name, rut = :rut, email = :email, phone = :phone, status = :status where id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(updateSql)
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
        finally {
            conn.close();
        }

    }

    @Override
    public Postulant getPostulant(int id){
		String sql = "SELECT * FROM postulant where id=:id";
        Connection conn = sql2o.open();
		try (conn) {
			return conn.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Postulant.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
	}

}