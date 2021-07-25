package com.webapp.microservice.repositories;
import java.util.List;
import com.webapp.microservice.models.Diploma;

public interface DiplomaRepository {
    public int countDiploma();
    public List<Diploma> getAllDiploma();
    public Diploma createDiploma(Diploma diploma);
    public boolean deleteDiploma(int id);
    public boolean updateDiploma(Diploma diploma);
    public Diploma getDiploma(int id);
}
