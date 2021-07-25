package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Diploma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class DiplomaRepositoryimp implements DiplomaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDiploma() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM diploma").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Diploma> getAllDiploma() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from diploma")
                    .executeAndFetch(Diploma.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Diploma createDiploma(Diploma diploma) {
        try(Connection conn = sql2o.open()){
            int insertedId = countDiploma()+1;
            conn.createQuery("INSERT INTO Diploma (id, name)"+
            " values (:id, :diplomaName)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("diplomaName", diploma.getName())
                    .executeUpdate().getKey();
                    diploma.setId(insertedId);
            return diploma;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean deleteDiploma(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM diploma WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean updateDiploma(Diploma diploma){
        String updateSql = "update diploma set name = :name where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("name", diploma.getName())
                .addParameter("id", diploma.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Diploma getDiploma(int id){
		String sql = "SELECT * FROM diploma where id=:id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Diploma.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

}