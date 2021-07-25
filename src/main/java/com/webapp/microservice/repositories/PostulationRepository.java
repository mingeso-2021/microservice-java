package com.webapp.microservice.repositories;
import java.util.List;
import com.webapp.microservice.models.Postulation;

public interface PostulationRepository {
    public int countPostulation();
    public List<Postulation> getAllPostulation();
    public Postulation createPostulation(Postulation postulation);
    public boolean deletePostulation(int id);
    public boolean updatePostulation(Postulation postulation);
    public Postulation getPostulation(int id);
}