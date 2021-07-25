package com.webapp.microservice.repositories;
import java.util.List;
import com.webapp.microservice.models.Secretary;

public interface SecretaryRepository {
    public int countSecretary();
    public List<Secretary> getAllSecretary();
    public Secretary createSecretary(Secretary secretary);
    public boolean deleteSecretary(int id);
    public boolean updateSecretary(Secretary secretary);
    public Secretary getSecretary(int id);
}