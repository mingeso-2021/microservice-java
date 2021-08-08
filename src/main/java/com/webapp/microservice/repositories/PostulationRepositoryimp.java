package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Postulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Query;

import java.util.Collections;
import java.util.List;

@Repository
public class PostulationRepositoryimp implements PostulationRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countPostulation() {
        int total = 0;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) FROM postulation").executeScalar(Integer.class);
            return total;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public List<Postulation> getAllPostulation() {
        List<Postulation> postulations = Collections.emptyList();
        Connection conn = sql2o.open();
        try(conn){
            postulations = conn.createQuery("select * from postulation")
                    .executeAndFetch(Postulation.class);
            return postulations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return postulations;
        }finally {
            conn.close();
        }

    }

    @Override
    public Postulation createPostulation(Postulation postulation) {
        Connection conn = sql2o.open();
        try(conn){
            int insertedId = countPostulation()+1;
            conn.createQuery("INSERT INTO postulation (id, id_diploma, id_postulant, id_evaluator, id_secretary, status)"+
            "values (:id, :postulationId_diploma, :postulationId_postulant, :postulationId_evaluator, :postulationId_secretary, :postulationId_status)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("postulationId_diploma", postulation.getId_diploma())
                    .addParameter("postulationId_postulant", postulation.getId_postulant())
                    .addParameter("postulationId_evaluator", postulation.getId_evaluator())
                    .addParameter("postulationId_secretary", postulation.getId_secretary())
                    .addParameter("postulationId_status", postulation.getStatus())
                    .executeUpdate().getKey();
                    postulation.setId(insertedId);
            return postulation;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            conn.close();
        }
    }
        

    @Override
    public boolean deletePostulation(int id){
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery("DELETE FROM postulation WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            conn.close();
        }

    }
    @Override
    public void updatePostulation(int id, Postulation postulation){
        String updateSql = "update postulation set status = :status where id = :idParam";
        Connection conn = sql2o.open();
        try (conn) {
            // search postulant by id (if exists)
            Postulation oldPostulation = conn.createQuery( "SELECT * FROM postulation where id = :idPostulation" )
                .addParameter("idPostulation", id)
                .executeAndFetchFirst( Postulation.class);
            // generate query for update a postulant
            Query query = conn.createQuery(updateSql);
            query.addParameter("idParam", id);
            if ( postulation.getStatus() != null ) query.addParameter("status", postulation.getStatus());
            else query.addParameter("status", oldPostulation.getStatus());
            // execute query
            query.executeUpdate();
            System.out.println("Postulation -status- has been successfully updated");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            conn.close();
        }

    }

    @Override
    public Postulation getPostulation(int id){
		String sql = "SELECT * FROM postulation where id=:id";
        Connection conn = sql2o.open();
		try (conn) {
			return conn.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Postulation.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            conn.close();
        }

    }

}