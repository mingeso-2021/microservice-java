package com.webapp.microservice.repositories;

import com.webapp.microservice.models.Secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class SecretaryRepositoryimp implements SecretaryRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countSecretary() {
        int total = 0;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) FROM secretary").executeScalar(Integer.class);
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }


    @Override
    public List<Secretary> getAllSecretary() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from secretary")
                    .executeAndFetch(Secretary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            return null;
        }
    }

    @Override
    public Secretary createSecretary(Secretary secretary) {
        try(Connection conn = sql2o.open()){
            int insertedId = countSecretary()+1;
            conn.createQuery("INSERT INTO Secretary (id, name, rut, email, phone, status)"+
            "values (:id, :secretaryName, :secretaryRut, :secretaryEmail, :secretaryPhone, :secretaryStatus)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("SecretaryName", secretary.getName())
                    .addParameter("SecretaryRut", secretary.getRut())
                    .addParameter("SecretaryEmail", secretary.getEmail())
                    .addParameter("SecretaryPhone", secretary.getPhone())
                    .addParameter("SecretaryStatus", secretary.getStatus())
                    .executeUpdate().getKey();
                    secretary.setId(insertedId);
            return secretary;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public boolean deleteSecretary(int id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM secretary WHERE id = :id").addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean updateSecretary(Secretary secretary){
        String updateSql = "update secretary set name = :name, rut = :rut, email = :email, phone = :phone, status = :status where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("name", secretary.getName())
                .addParameter("rut", secretary.getRut())
                .addParameter("email", secretary.getEmail())
                .addParameter("phone", secretary.getPhone())
                .addParameter("status", secretary.getStatus())
                .addParameter("id", secretary.getId())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Secretary getSecretary(int id){
		String sql = "SELECT * FROM secretary where id=:id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Secretary.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

}