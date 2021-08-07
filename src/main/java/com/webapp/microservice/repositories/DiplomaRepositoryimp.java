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
    public Integer countDiploma() {
        final Integer total;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) FROM diploma").executeScalar(Integer.class);
            return total;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public List<Diploma> getAllDiploma() {
        final String query = "select * from diploma";
        final List<Diploma> diplomas;
        Connection conn = sql2o.open();
        try(conn){
            diplomas = conn.createQuery(query).executeAndFetch(Diploma.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public Diploma createDiploma(Diploma diploma) {
        Connection conn = sql2o.open();
        try(conn){
            int insertedId = countDiploma()+1;
            final String query = "INSERT INTO Diploma (id, name, status) values (:id, :diplomaName)";
            conn.createQuery(query, true)
                    .addParameter("id",  insertedId)        
                    .addParameter("diplomaName", diploma.getName())
                    .addParameter("diplomaStatus", diploma.getStatus())
                    .executeUpdate().getKey();
                    diploma.setId(insertedId);
            return diploma;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public boolean deleteDiploma(int id){
        final String query = "DELETE FROM diploma WHERE id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query).addParameter("id", id)
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
    public boolean updateDiploma(Diploma diploma){
        final String updateSql = "update diploma set name = :name where id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(updateSql)
                .addParameter("name", diploma.getName())
                .addParameter("id", diploma.getId())
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
    public Diploma getDiploma(int id){
		final String sql = "SELECT * FROM diploma where id=:id";
		Diploma diploma;
        Connection conn = sql2o.open();
		try (conn) {
			 diploma = conn.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Diploma.class);
            return diploma;
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
	}

}