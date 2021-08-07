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
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) FROM evaluator").executeScalar(Integer.class);
            return total;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }

    }

    @Override
    public List<Evaluator> getAllEvaluator() {
        Connection conn = sql2o.open();
        try(conn){
            return conn.createQuery("select * from evaluator")
                    .executeAndFetch(Evaluator.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public Evaluator createEvaluator(Evaluator evaluator) {
        Connection conn = sql2o.open();
        try(conn){
            int insertedId = countEvaluator()+1;
            conn.createQuery("INSERT INTO evaluator (id, name, rut, email, phone, status)"+
            "values (:id, :evaluatorName, :evaluatorRut, :evaluatorEmail, :evaluatorPhone, :evaluatorStatus)", true)
                    .addParameter("id",  insertedId)        
                    .addParameter("evaluatorName", evaluator.getName())
                    .addParameter("evaluatorRut", evaluator.getRut())
                    .addParameter("evaluatorEmail", evaluator.getEmail())
                    .addParameter("evaluatorPhone", evaluator.getPhone())
                    .addParameter("evaluatorStatus", evaluator.getStatus())
                    .executeUpdate().getKey();
                    evaluator.setId(insertedId);
            return evaluator;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
        
    }
    @Override
    public boolean deleteEvaluator(int id){
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery("DELETE FROM evaluator WHERE id = :id").addParameter("id", id)
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
    public boolean updateEvaluator(Evaluator evaluator){
        String updateSql = "update evaluator set name = :name, rut = :rut, email = :email, phone = :phone, status = :status where id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(updateSql)
                .addParameter("name", evaluator.getName())
                .addParameter("rut", evaluator.getRut())
                .addParameter("email", evaluator.getEmail())
                .addParameter("phone", evaluator.getPhone())
                .addParameter("id", evaluator.getId())
                .addParameter("status", evaluator.getStatus())
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
    public Evaluator getEvaluator(int id){
		String sql = "SELECT * FROM evaluator where id=:id";
		Evaluator evaluator;
        Connection conn = sql2o.open();
		try (conn) {
			evaluator = conn.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Evaluator.class);
			return evaluator;

		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
	}

}