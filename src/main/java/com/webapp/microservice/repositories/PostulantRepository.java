package com.webapp.microservice.repositories;
import java.util.List;
import com.webapp.microservice.models.Postulant;

public interface PostulantRepository {
    public int countPostulant();
    public List<Postulant> getAllPostulant();
    public Postulant createPostulant(Postulant postulant);
    public boolean deletePostulant(int id);
    public boolean updatePostulant(Postulant postulant);
    public Postulant getPostulant(int id);
}